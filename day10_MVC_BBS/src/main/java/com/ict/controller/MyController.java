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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ict.db.BVO;
import com.ict.db.CVO;
import com.ict.db.DAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class MyController {
	@Autowired
	private DAO dao;

	@RequestMapping("list.do")
	public ModelAndView listCommand() {
		ModelAndView mv = new ModelAndView("list");
		List<BVO> list = dao.getList();
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("write.do")
	public ModelAndView writeCommand() {
		return new ModelAndView("write");
	}

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
			if(result > 0) {
				return new ModelAndView("redirect:list.do");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@RequestMapping("onelist.do")
	public ModelAndView oneListCommand(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("onelist");
		String b_idx = req.getParameter("b_idx");
		// 조회수 업데이트
		int result = dao.getHit(b_idx);
		
		// 상세 보기
		BVO bvo = dao.getOneList(b_idx);
		
		//  수정과 삭제를 위해서 session에 담기
		req.getSession().setAttribute("bvo", bvo);
		
		// 댓글 가져오기
		List<CVO> c_list = dao.getC_List(b_idx);
		req.setAttribute("c_list", c_list);
		return mv;
	}
	
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
}
