package com.ict.edu03;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("1. 오라클");
		System.out.println("2. MySQL");
		System.out.print("선택하세요>>");
		int su = scan.nextInt();
		DAO dao = null;
		switch (su) {
		case 1: dao = new OracleDAO(); break;
		case 2: dao = new MySQLDAO(); break;
		}
		
		// Service 클래스의 biz() 사용하기 위해서는
		// Service 클래스를 객체로 만들어야 한다.
		Service service = new Service(dao);
		
		service.biz();
		scan.close();
	}
}
