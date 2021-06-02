package com.ict.edu;

import org.springframework.stereotype.Component;

@Component
public class MySQLDAO implements DAO{
	public MySQLDAO() {
		System.out.println("MySQL 생성자");
	}
	public void prn() {
		System.out.println("MySQL 실행 메소드");
	}
}
