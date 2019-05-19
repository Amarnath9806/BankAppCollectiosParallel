package com.cg.BankAppCollectionsParallel.utility;

public class CannotWithdrawException extends Exception{
	public CannotWithdrawException() {
		System.out.println("Cannot withdraw. Low on balance");
	}
}
