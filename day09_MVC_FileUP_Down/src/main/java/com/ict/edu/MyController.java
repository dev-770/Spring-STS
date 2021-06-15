package com.ict.edu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class MyController {
	
	@RequestMapping(value="fileup.do", method=RequestMethod.POST)
	public ModelAndView FileUp01(HttpServletRequest req, HttpServletResponse resp) {
		try {
			ModelAndView mv = new ModelAndView("result");
			// cos.jar => MultipartRequest 클래스 지원
			//					=> request로 파라미터값을 받을 수 없다.
			// 톰켓안에 프로젝트 안에 WEB-INF 안에 존재하는 폴더
			String path =  req.getSession().getServletContext().getRealPath("/resources/upload");
			MultipartRequest mr = // request 정보, 저장위치, 100MB, 인코딩, 파일 중복 유무
					new MultipartRequest(req, path, 100*1024*1024, "utf-8", new DefaultFileRenamePolicy());

			/* 업로드 끝 */
			String name = mr.getParameter("name");
			// 저장 당시 이름(같은 파일이 있으면 이름뒤에 숫자가 붙는다.
			String file_name1 = mr.getFilesystemName("file_name");
			// 올린 당시 이름
			String file_name2 = mr.getOriginalFileName("file_name");
			String contentType = mr.getContentType("file_name");
			
			File file = mr.getFile("file_name");
			String file_name3 = file.getName(); // 저장 당시 이름과 같음
			long filesize= file.length()/1024; // 파일 크기 (Byte) KB
			long date  = file.lastModified(); // 마지막 수정 날짜
			
			//date는 1970.01.01.0.0.0 부터 지금 현재 시간까지 날짜를 수치화 한 것
			SimpleDateFormat format =
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
			String fdate = format.format(date);
			
			req.setAttribute("name", name);
			req.setAttribute("file_name1", file_name1);
			req.setAttribute("file_name2", file_name2);
			req.setAttribute("file_name3", file_name3);
			req.setAttribute("contentType", contentType);
			req.setAttribute("filesize", filesize);
			req.setAttribute("date", date);
			req.setAttribute("fdate", fdate);
			
			return mv;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@RequestMapping(value="fileup2.do", method=RequestMethod.POST)
	public ModelAndView FileUp02(HttpServletRequest req, HttpServletResponse resp,
			@RequestParam("name")String name,
			@RequestParam("file_name")MultipartFile file_name) {
		try {
			ModelAndView mv = new ModelAndView("result");
			
			String path =  req.getSession().getServletContext().getRealPath("/resources/upload");
			String f_name2 = file_name.getOriginalFilename();
			String file_type = file_name.getContentType();
			long file_size = file_name.getSize()/1024;
			
			// 저장할 원본 파일
			byte[] in = file_name.getBytes();
			
			// 저장 위치와 파일 이름
			File out = new File(path, f_name2);
			
			SimpleDateFormat day =
					new SimpleDateFormat("yyyy-MM-dd hh:mm:ss E");
			String lastday = day.format(out.lastModified());
			System.out.println(lastday);
			
			// 필요한 정보 저장
			req.setAttribute("name", name);
			req.setAttribute("file_name2", f_name2);
			req.setAttribute("contentType", file_type);
			req.setAttribute("filesize", file_size);
			req.setAttribute("fdate", lastday);
			
			// 복사 (UPLOAD)
			FileCopyUtils.copy(in, out);
			
			return mv;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	/*
	@RequestMapping(value="down.do", method=RequestMethod.GET)
	public void Filedown2(@RequestParam("file_name") String file_name,
			HttpServletRequest req, HttpServletResponse res) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
//		FileOutputStream fos = null; 브라우저에서 다운받기 때문에 사용 안함
		BufferedOutputStream bos = null;
		
		try {
			// 실제 저장 위치 + 파일 지정
			String path = req.getSession().getServletContext().getRealPath("/resources/upload/"+file_name);
			
			// 브라우저 설정(첨부파일 설정)
			res.setContentType("application/x-msdownload");
			res.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(file_name,"UTF-8"));
			
			// 실제 다운로드
			File file = new File(new String(path.getBytes("UTF-8")));
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(res.getOutputStream());
			
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
	*/
	
	@RequestMapping(value="down.do", method=RequestMethod.GET)
	public void Filedown(@RequestParam("file_name") String file_name,
			HttpServletRequest req, HttpServletResponse res) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
//		FileOutputStream fos = null; 브라우저에서 다운받기 때문에 사용 안함
		BufferedOutputStream bos = null;
		
		try {
			// 실제 저장 위치 + 파일 지정
			String path = req.getSession().getServletContext().getRealPath("/resources/upload/"+file_name);
			
			// 브라우저 설정(첨부파일 설정)
			res.setContentType("application/x-msdownload");
			res.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(file_name,"UTF-8"));
			
			// 실제 다운로드
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
}
