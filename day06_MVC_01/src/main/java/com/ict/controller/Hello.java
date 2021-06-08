package com.ict.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// 무조건 Controller를 상속
public class Hello implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result01");
		
		// 원하는 일처리
		
		// 데이터 저장
		request.setAttribute("name", "둘리");
		request.setAttribute("age", 15);
		request.setAttribute("gender", true);
		
		// servlet-context.xml로 modelandview를 반환
		return mv;
	}

}
