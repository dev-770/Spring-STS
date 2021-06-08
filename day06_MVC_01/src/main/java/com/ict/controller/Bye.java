package com.ict.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Bye implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("out/result03");
		
		// 배열저장
		String[] dogName = {"토리","진솔이","진숙이","땅콩이","바둑이"};
		
		// 컬렉션 저장
		ArrayList<String> carName = new ArrayList<String>();
		carName.add("카렌스");
		carName.add("카니발");
		carName.add("카스타");
		carName.add("스타렉스");
		carName.add("봉고");
		
		request.setAttribute("dogName", dogName);
		mv.addObject("carName", carName);
		
		return mv;
	}

}
