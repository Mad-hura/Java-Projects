package com.lumen.quest2;

public class SciCalcImplement extends BasicCalculator implements Scientific {

	@Override
	public void square(int x) {
		System.out.println("Suqare:"+(Math.pow(x, 2)));
		
	}

	@Override
	public void cube(int x) {
		System.out.println("Cube:"+(Math.pow(x, 3)));
		
	}

}
