package com.lumen.quest4;

import java.util.function.Supplier;

public class StringUppersupplierandLambda {
	public static void main(String[] args) {
		
	Supplier<String> supplier =()-> "OnePiece".toUpperCase();
    String result = supplier.get();
    System.out.println(result);

}
}