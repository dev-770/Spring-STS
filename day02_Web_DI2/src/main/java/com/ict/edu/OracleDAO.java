package com.ict.edu;

import org.springframework.stereotype.Component;

@Component("dao")
public class OracleDAO implements DAO {
	
	public OracleDAO() {
		System.out.println("오라클 DAO 생성자");
	}
	
	public void prn() {
		System.out.println("오라클 실행 메소드");
	}
}
