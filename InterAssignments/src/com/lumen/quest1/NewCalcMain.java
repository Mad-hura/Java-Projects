package com.lumen.quest1;

public class NewCalcMain {
	public static void main(String[] args) {
		NewCalculator add= (int x,int y)->System.out.println("Sum:"+(x+y));
		NewCalculator difference =(int x,int y)->System.out.println("Diff:"+(x-y));
		NewCalculator product = (int x,int y)->System.out.println("Product:"+(x*y));
		NewCalculator div =(int x,int y)->System.out.println("Division:"+(x/y));
	    add.calculate(3, 3);
	    difference.calculate(3, 3);
	    product.calculate(3, 3);
	    div.calculate(3, 3);
	    
	    
}
}