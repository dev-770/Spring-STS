package com.ict.edu01;

public class TestMain {
	public static void main(String[] args) {
		// 오라클 prn()
		OracleDAO dao01 = new OracleDAO();
		dao01.prn();
		
		// MySQL prn()
		MySQLDAO dao02 = new MySQLDAO();
		dao02.prn();
	}
}
