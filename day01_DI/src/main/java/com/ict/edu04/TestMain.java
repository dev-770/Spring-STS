package com.ict.edu04;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ict/edu04/Config.xml");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("1. 오라클");
		System.out.println("2. MySQL");
		System.out.print("선택하세요>>");
		int su = scan.nextInt();

		Service service = null;
		
		switch (su) {
		case 1: service = (Service) context.getBean("dao1"); break;
		case 2: service = (Service) context.getBean("dao2"); break;
		}
		
		service.biz();
		scan.close();
	}
}
