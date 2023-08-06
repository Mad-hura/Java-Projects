package com.lumen.quest2;

public class CalcMain {
	public static void main(String[] args) {
		Calculator calculator = new BasicCalculator();
		calculator.add(2,2);
		calculator.product(3, 2);
		calculator.difference(3, 2);
		
		Scientific scientific = new SciCalcImplement();
		scientific.cube(3);
		scientific.square(3);
		
		
	}
	
}
