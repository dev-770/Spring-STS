package com.ict.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping(value="f_up.do", method = RequestMethod.POST)
	public ModelAndView getF_up(
			@RequestParam("name")String name,
			@RequestParam("file_name")MultipartFile file_name,
			HttpServletRequest req) {
		try {
			ModelAndView mv = new ModelAndView("result");
			// 실제 저장 위치
			String path = req.getSession().getServletContext().getRealPath("/resources/upload");
			
			// name은 @RequestParam에서 처리함
			String f_name = file_name.getOriginalFilename();
			String f_type = file_name.getContentType();
			long size = file_name.getSize() / 1024; // KB
			
			// 업로드할 파일을 byte[] 만듬
			byte[] in = file_name.getBytes();
			
			// 저장장소외 이름 지정
			File out = new File(path, f_name);
			
			// 복사 하기
			FileCopyUtils.copy(in, out);
			
			mv.addObject("name", name);
			mv.addObject("file_name", f_name);
			mv.addObject("file_type", f_type);
			mv.addObject("size",size);
			System.out.println(name + f_name);
			
			return mv;
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	@RequestMapping("down.do")
	public void downFile(@RequestParam("file_name") String file_name,
			HttpServletRequest req, HttpServletResponse res) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
//		FileOutputStream fos = null; 브라우저에서 다운받기 때문에 사용 안함
		BufferedOutputStream bos = null;
		
		try {
			// 실제 저장 위치 + 파일 지정
			String path = req.getSession().getServletContext().getRealPath("/resources/upload/"+file_name);
			
			// 브라우저에 설정
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
}
