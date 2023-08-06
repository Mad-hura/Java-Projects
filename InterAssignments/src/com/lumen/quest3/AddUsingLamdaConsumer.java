package com.lumen.quest3;

import java.util.function.BiConsumer;


public class AddUsingLamdaConsumer {
	public static void main(String[] args) {
		NewCalculator add= (int x,int y)->System.out.println("Sum:"+(x+y));
		add.calculate(50,10);
		BiConsumer<Integer,Integer> addConsumer = (x,y)->System.out.println("Sum:"+(x+y));
		addConsumer.accept(60, 20);
	}

}
