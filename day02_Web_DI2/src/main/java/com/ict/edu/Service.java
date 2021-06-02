package com.ict.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("service")
public class Service {
	// 클래스가 자료형 (참조 자료형 = 객체 자료형)
	@Autowired
	private DAO dao;
	
	public Service() {}

	public Service(DAO dao) {
		System.out.println("service 생성자");
		this.dao = dao;
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}

	// 실행되고 싶은 메소드
	public void biz() {
		dao.prn();
	}
}
