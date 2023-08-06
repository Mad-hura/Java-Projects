package com.lumem.quest5;

import java.util.function.BiConsumer;

public class AdminAgeBiconsumer {
	public static void main(String[] args) {
		BiConsumer<String, Integer> con = (name,age)->{
		if(name.equals("Admin")&& (age>30)) System.out.println("Welcome Admin");
		else System.out.println("Wrong User");};
		con.accept("Admin", 32);
	}

}
