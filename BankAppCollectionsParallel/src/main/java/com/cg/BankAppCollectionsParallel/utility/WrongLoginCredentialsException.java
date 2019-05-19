package com.cg.BankAppCollectionsParallel.utility;

public class WrongLoginCredentialsException extends Exception{
	public WrongLoginCredentialsException() {
		System.out.println("Credentials are wrong. Enter valid credentials");
		
	}
}
