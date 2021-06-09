package com.ict.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.model.MyCalc;
import com.ict.model.VO;

@Controller
public class MyController {
	
	@Autowired
	private MyCalc myCalc;
	public void setMyCalc(MyCalc myCalc) {
		this.myCalc = myCalc;
	}
	// 파라미터 받기 : 1. JSP 처럼 받기
	/*
	@RequestMapping("param.do")
	public ModelAndView myCommand(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("result");
		// 파라미터 받아서 일처리 하기
		int s1 = Integer.parseInt(request.getParameter("s1"));
		int s2 = Integer.parseInt(request.getParameter("s2"));
		String op = request.getParameter("op");
		String[] hobby = request.getParameterValues("hobby");
		
		int res = 0;
		switch (op) {
		case "+":
			res = s1 + s2;
			break;
		case "-":
			res = s1 - s2;
			break;
		case "*":
			res = s1 * s2;
			break;
		case "/":
			res = s1 / s2;
			break;
		}
		
		mv.addObject("s1", s1);
		mv.addObject("s2", s2);
		mv.addObject("op", op);
		mv.addObject("res", res);
		mv.addObject("hobby", hobby);
		return mv;
	}
	*/
	// 2. VO를 이용한 파라미터 받기 (vo와 파라미터이름이 같으면 자동으로 들어간다.)
	@RequestMapping("param.do")
	public ModelAndView myCommand(VO vo) {
		ModelAndView mv = new ModelAndView("result");
		// 파라미터 받아서 일처리 하기
		int s1 = Integer.parseInt(vo.getS1());
		int s2 = Integer.parseInt(vo.getS2());
		String op = vo.getOp();
		String[] hobby = vo.getHobby();
		
		int res = 0;
		switch (op) {
		case "+":
			res = myCalc.add(s1, s2);
			break;
		case "-":
			res = myCalc.sub(s1, s2);
			break;
		case "*":
			res = myCalc.mul(s1, s2);
			break;
		case "/":
			res = myCalc.div(s1, s2);
			break;
		}
		
		mv.addObject("s1", s1);
		mv.addObject("s2", s2);
		mv.addObject("op", op);
		mv.addObject("res", res);
		mv.addObject("hobby", hobby);
		return mv;
	}

	// 3. Model 사용
	// 들어온 파라미터를 VO vo 담고 리턴할 때 
	// Model 속성을 이용해서 리턴한다.
	/*
	@RequestMapping("param.do")
	public ModelAndView myCommand(@ModelAttribute("mvo")VO vo) {
		ModelAndView mv = new ModelAndView("result");
		// 파라미터 받아서 일처리 하기
		int s1 = Integer.parseInt(vo.getS1());
		int s2 = Integer.parseInt(vo.getS2());
		String op = vo.getOp();
		String[] hobby = vo.getHobby();
		
		int res = 0;
		switch (op) {
		case "+":
			res = s1 + s2;
			break;
		case "-":
			res = s1 - s2;
			break;
		case "*":
			res = s1 * s2;
			break;
		case "/":
			res = s1 / s2;
			break;
		}
		
		mv.addObject("res", res);
		
		return mv;
	}
	*/
	
}
