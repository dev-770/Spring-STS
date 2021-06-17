package com.ict.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ict.db.BVO;
import com.ict.db.CVO;
import com.ict.db.DAO;
import com.ict.model.Paging;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class MyController {
	@Autowired
	private DAO dao;
	
	@Autowired
	private Paging pvo;

	/* 리스트 처리 */
	@RequestMapping("list.do")
	public ModelAndView listCommand(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("list");
		// 전체 게시물 보기 
		// List<BVO> list = dao.getList();
		// mv.addObject("list",list);
		
		// 1. 전체 게시물 수 구하기 
		 int count = dao.getTotalCount();
		 pvo.setTotalRecord(count);
	
		// 2. 전체 게시물의 수를 이용해서 전체 페이지 수 구하기 
		 if(pvo.getTotalRecord()<= pvo.getNumPerPage()) {
			pvo.setTotalPage(1);
		 }else {
			 pvo.setTotalPage(pvo.getTotalRecord()/pvo.getNumPerPage());
			 if(pvo.getTotalRecord() % pvo.getNumPerPage()!=0) {
				 pvo.setTotalPage(pvo.getTotalPage()+1);
			 }
		 }
			
		// 3. 파라미터로 넘어온 cPage가 현재 페이지 가 된다.
		//   list.do일때는 무조건 cPage값을 넘겨야 된다. 
		 String cPage = request.getParameter("cPage");
		 pvo.setNowPage(Integer.parseInt(cPage));
		
		// 4. 시작번호, 끝번호 구하기
		 pvo.setBegin((pvo.getNowPage()-1)*pvo.getNumPerPage()+1);
		 pvo.setEnd((pvo.getBegin()-1)+pvo.getNumPerPage());
		
		// 5. 시작블록, 끝블록 구하기 
		pvo.setBeginBlock((int)(pvo.getNowPage()-1)/pvo.getPagePerBlock()*pvo.getPagePerBlock()+1);
		pvo.setEndBlock(pvo.getBeginBlock()+pvo.getPagePerBlock()-1);
		
		// 주의 : 끝블록이 전체 페이지의 수보다 클경우가 있다.
		//  이 경우에는 끝블록을 전체 페이지의 수로 변경한다.
		if(pvo.getEndBlock() > pvo.getTotalPage()) {
			pvo.setEndBlock(pvo.getTotalPage());
		}
		
		// DB처리 (시작번호와 끝번호로 DB처리)
		List<BVO> list = dao.getList(pvo.getBegin(), pvo.getEnd());
		
		// 저장
		mv.addObject("list", list);
		mv.addObject("pvo", pvo);
		
		return mv;
	}
	
/*
	@RequestMapping("write.do")
	public ModelAndView writeCommand(HttpServletRequest req) {
		String cPage = req.getParameter("cPage");
		req.setAttribute("cPage", cPage);
		return new ModelAndView("write");
	}
*/
	/* 글쓰기 */
	@RequestMapping("write.do")
	public ModelAndView writeCommand(@ModelAttribute("cPage")String cPage) { 
		return new ModelAndView("write");
	}

	/* 글작성 올리기 */
	@RequestMapping(value = "write_ok.do", method = RequestMethod.POST)
	public ModelAndView write_OKCommand(HttpServletRequest req) {
		try {
			String path = req.getSession().getServletContext().getRealPath("/resources/upload");
			MultipartRequest mr = // request 정보, 저장위치, 100MB, 인코딩, 파일 중복 유무
					new MultipartRequest(req, path, 100 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			BVO bvo = new BVO();
			bvo.setSubject(mr.getParameter("subject"));
			bvo.setWriter(mr.getParameter("writer"));
			bvo.setContent(mr.getParameter("content"));
			bvo.setPwd(mr.getParameter("pwd"));
			System.out.println(path);
			
			//  파일 처리
			if (mr.getFile("file_name") != null) {
				// 첨부파일 있음
				bvo.setFile_name(mr.getFilesystemName("file_name"));
			}
			else {
				// 첨부파일 없음
				bvo.setFile_name("");
			}
			int result = dao.getInsert(bvo);
			// String cPage = mr.getParameter("cPage");
			if(result > 0) {
				return new ModelAndView("redirect:list.do?cPage=1");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	/* 내용 보기 */
	@RequestMapping("onelist.do")
	public ModelAndView oneListCommand(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("onelist");
		String b_idx = req.getParameter("b_idx");
		String cPage = req.getParameter("cPage");
		// 조회수 업데이트
		int result = dao.getHit(b_idx);
		
		// 상세 보기
		BVO bvo = dao.getOneList(b_idx);
		
		//  수정과 삭제를 위해서 session에 담기
		req.getSession().setAttribute("bvo", bvo);
		
		// 댓글 가져오기
		List<CVO> c_list = dao.getC_List(b_idx);
		req.setAttribute("c_list", c_list);
		req.setAttribute("cPage", cPage);
		return mv;
	}
	
	/* 다운로드 처리 */
	@RequestMapping(value="down.do", method = RequestMethod.GET)
	public void downCommand(@RequestParam("file_name") String file_name,
			HttpServletRequest req, HttpServletResponse res) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			String path = req.getSession().getServletContext().getRealPath("/resources/upload/"+file_name);
			
			res.setContentType("application/x-msdownload");
			res.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(file_name,"UTF-8"));
			
			File file = new File(new String(path.getBytes("UTF-8")));
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(res.getOutputStream());
			
			int b = 0;
			while((b=bis.read()) != -1) {
				bos.write(b);
			}
			bos.flush();
			
			FileCopyUtils.copy(bis, bos);
		}catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				bos.close();
				bis.close();
				fis.close();
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	/* 댓글 작성 */
	@RequestMapping("comm_ins.do")
	public ModelAndView comm_insCommand(HttpServletRequest req, CVO cvo) {
		BVO bvo = (BVO)req.getSession().getAttribute("bvo");
		
		cvo.setB_idx(bvo.getB_idx());
		
		int result = dao.getC_Insert(cvo);
		if(result > 0) {
			return new ModelAndView("redirect:onelist.do?b_idx="+bvo.getB_idx());
		}
		return null;
	}
	
	/* 댓글 삭제 */
	@RequestMapping("comm_del.do")
	public ModelAndView comm_delCommand(CVO cvo) {
		int result = dao.getC_Delete(cvo);
				
		if(result > 0) {
			return new ModelAndView("redirect:onelist.do?b_idx="+cvo.getB_idx());
		}
		return null;
	}
}
