package com.ict.controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.model.MyCul;
import com.ict.model.VO;

@Controller
public class MyController {
	
	@Inject
	private MyCul myCul;

	public void setMyCul(MyCul myCul) {
		this.myCul = myCul;
	}

	@RequestMapping("param.do")
	public ModelAndView MyCommand(@ModelAttribute("mvo")VO vo) {
		
		ModelAndView mv = new ModelAndView("result");
		
		String name = vo.getName();
		int kor = vo.getKor();
		int eng = vo.getEng();
		int math = vo.getMath();
		
		int sum = myCul.getSum(kor, eng, math);
		double avg = myCul.getAvg(sum);
		String grad = myCul.getGrad(avg);
		
		mv.addObject("sum", sum);
		mv.addObject("avg", avg);
		mv.addObject("grad", grad);
		
		return mv;
	}
}
