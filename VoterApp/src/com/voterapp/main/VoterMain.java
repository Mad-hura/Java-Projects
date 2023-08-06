package com.voterapp.main;

import java.util.Scanner;

import com.voterapp.exception.InValidVoterException;
import com.voterapp.service.ElectionBoothImpl;

public class VoterMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter ur age: ");
		int age = scanner.nextInt();
		System.out.println("Enter ur locality: ");
		String locality = scanner.next();
		System.out.println("Enter ur voter-id: ");
		int voterId= scanner.nextInt();
		
		ElectionBoothImpl election = new ElectionBoothImpl();
		try {
			if(election.checkEligibility(age, locality, voterId))
				System.out.println("you are eligible to cast vote");
		}catch(InValidVoterException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
