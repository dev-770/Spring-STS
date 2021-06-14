package com.ict.controller;

import java.net.http.HttpClient.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.edu.DAO;
import com.ict.edu.VO;

@Controller
public class MyController {
	@Autowired
	private DAO dao;

	@RequestMapping("list.do")
	public ModelAndView listCommand() {
		ModelAndView mv = new ModelAndView("list");
		List<VO> list = dao.getList();
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("join.do")
	public ModelAndView joinCommand() {
		return new ModelAndView("join");
	}
	
	@RequestMapping("join_ok.do")
	public ModelAndView join_okCommand(VO vo) {
		// insert 처리하고 성공하면 list이동
		int result = dao.getInsert(vo);
		if(result > 0) {
			// 삽입 성공 리다이렉트를 이용해서 list로 이동
			return new ModelAndView("redirect:list.do");
		}
		return null;
	}
	
	@RequestMapping("detail.do")
	public ModelAndView detailCommand(VO vo, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("detail");
		VO one_vo = dao.getDetail(vo);
		
		// 수정, 삭제를 위해서 session 저장하자
		req.getSession().setAttribute("vo", one_vo);
		return mv;
	}
	
	@RequestMapping("delete.do")
	public ModelAndView deleteCommand() {
		return new ModelAndView("delete");
	}
	
	@RequestMapping("delete_ok.do")
	public ModelAndView delete_okCommand(HttpServletRequest req) {
		// 삭제 후 list로 이동 (삭제할 idx는 session에서 가지고 있다.)
		// 세션에 저장된 vo 불러오기
		VO vo = (VO) req.getSession().getAttribute("vo");
		int result = dao.getDelete(vo);
		if(result > 0) {
			return new ModelAndView("redirect:list.do");
		}
		return null;
	}
	
	@RequestMapping("update.do")
	public ModelAndView updateCommand() {
		return new ModelAndView("update");
	}
	
	@RequestMapping("update_ok.do")
	public ModelAndView update_okCommand(VO vo) {
		// 업데이트 성공하면 detail.do로 이동 (idx를 보내야 한다.)
		int result = dao.getUpdate(vo);
		if(result > 0) {
			return new ModelAndView("redirect:detail.do?idx="+vo.getIdx());
		}
		return null;
	}
}
