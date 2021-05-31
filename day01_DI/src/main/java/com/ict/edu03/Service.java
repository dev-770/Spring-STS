package com.ict.edu03;

public class Service {
	// 클래스가 자료형 (참조 자료형 = 객체 자료형)
	private DAO dao;
	
	public Service() {}

	public Service(DAO dao) {
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
