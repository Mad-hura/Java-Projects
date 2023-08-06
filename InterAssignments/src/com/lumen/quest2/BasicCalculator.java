package com.lumen.quest2;

public class BasicCalculator implements Calculator{

	@Override
	public void add(int x, int y) {
		System.out.println("Sum:"+(x+y));
		
	}

	@Override
	public void product(int x, int y) {
		System.out.println("Product:"+(x*y));	
		
	}
	

}
