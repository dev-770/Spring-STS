package com.ict.model;

import org.springframework.stereotype.Service;

@Service("myCalc")
public class MyCalc {

	public int add(int s1, int s2) {
		return s1 + s2;
	}
	public int sub(int s1, int s2) {
		return s1 - s2;
	}
	public int mul(int s1, int s2) {
		return s1 * s2;
	}
	public int div(int s1, int s2) {
		return s1 / s2;
	}
}
