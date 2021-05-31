package com.ict.edu02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
//		// Spring Container : 객체 (Bean)을 생성하고 관리한다.
//		// Spring Container 역할하는 클래스
//		// BeanFactory <= ApplicationContext <= ClassPathXmlApplicationContext()
//		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ict/edu02/config.xml");
//		
//		// getBean("xml의 객체 id")
//		// 오라클
		OracleDAO oracle = (OracleDAO) context.getBean("oracle");
		oracle.prn();
		
	}
}
