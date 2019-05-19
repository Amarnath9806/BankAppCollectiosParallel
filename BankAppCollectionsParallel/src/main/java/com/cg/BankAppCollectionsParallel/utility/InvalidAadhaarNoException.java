package com.cg.BankAppCollectionsParallel.utility;

public class InvalidAadhaarNoException extends Exception{
	public InvalidAadhaarNoException(){
		System.out.println("Aadhar card number should be only 12 digits.");
	}
}
