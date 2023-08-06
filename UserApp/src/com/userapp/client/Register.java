package com.userapp.client;

import java.util.Scanner;

import com.userapp.exception.NameExistsException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;
import com.userapp.service.ValidationServiceImpl;

public class Register {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ValidationServiceImpl validate = new ValidationServiceImpl();
		System.out.println("Enter username:");
		String username = scanner.nextLine();
		try {
			  validate.validateUsername(username) ;
			  System.out.println("Welcome "+username);
		}catch(NameExistsException e) {
			System.out.println(e.getMessage());
			System.out.println("enter password:");
			String password = scanner.nextLine();
			try {
				validate.validatePassword(password);
				System.out.println("welcome "+username);
			}catch(TooLongException|TooShortException e1) {
				System.out.println(e1.getMessage());
			}
		}

	}
}
