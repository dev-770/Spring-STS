package com.ict.model;

import org.springframework.stereotype.Service;

@Service("myCul")
public class MyCul {
	public int getSum (int kor, int eng, int math) {
		return kor + eng + math;
	}
	public double getAvg(int sum) {
		return (int)(sum/3.0*10)/10.0;
	}
	public String getGrad(double avg) {
		String grad = "";
		if(avg >= 90)
			grad = "A학점";
		else if(avg >= 80)
			grad = "B학점";
		else if(avg >= 70) 
			grad = "C학점";
		else
			grad = "F학점";
	
		return grad;
	}
}
