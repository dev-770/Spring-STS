package com.ict.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Hi implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("result02");
		
		// 원하는 일처리
		
		// 데이터 저장(request)
		request.setAttribute("name", "태권브이");
		mv.addObject("age", 1004);
		
		// session에 저장
		request.getSession().setAttribute("id", "hong_jd");
		return mv;
	}

}
