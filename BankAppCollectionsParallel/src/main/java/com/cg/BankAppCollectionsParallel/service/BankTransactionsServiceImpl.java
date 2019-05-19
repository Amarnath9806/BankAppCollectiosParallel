package com.cg.BankAppCollectionsParallel.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.cg.BankAppCollectionsParallel.Dao.BankTransactionsDAO;
import com.cg.BankAppCollectionsParallel.Dao.BankTransactionsDAOImpl;
import com.cg.BankAppCollectionsParallel.MainUI.MainUI;
import com.cg.BankAppCollectionsParallel.model.CustomerDetails;
import com.cg.BankAppCollectionsParallel.model.TransactionDetails;
import com.cg.BankAppCollectionsParallel.utility.CannotWithdrawException;
import com.cg.BankAppCollectionsParallel.utility.AadhaarAlreadyExistsException;

public class BankTransactionsServiceImpl implements BankTransactionsService {
	BankTransactionsDAO dao= new BankTransactionsDAOImpl();
	public long registration(CustomerDetails customerDetails) {
		
		return dao.registration(customerDetails);
	}

//	public long set() {
//		
//		return 0;
//		
//	}
	
	public CustomerDetails login(long accountNo, String password) {
		return dao.login(accountNo, password);
	}
	public boolean validation(String aadharNo) {
		boolean check = false;
		if(aadharNo.length()==12) {
			if(dao.validation(aadharNo)) {
				check=true;
			}else {
				try {
					throw new AadhaarAlreadyExistsException();
				} catch (AadhaarAlreadyExistsException e) {
				}
			}
		}else {
			check=false;
		}
		return check;

	}
	
	public boolean validateNumber(String mobile) {
		if(mobile.length()==10) {
			return true;
		}
		else {
			return false;
		}
	}
	public long withdraw(long accountNo, long amount) {
		long balance=dao.withdraw(accountNo, amount);
		if(balance<0){
			try {
				throw new CannotWithdrawException();
			} catch (CannotWithdrawException e) {
			}
		}
		return balance;
	}

	public long deposit(long accountNo, long amount) {
		// TODO Auto-generated method stub
		return dao.deposit(accountNo, amount);
	}

	public long fundTransfer(TransactionDetails transactionDetails) {
		// TODO Auto-generated method stub
		return dao.fundTransfer(transactionDetails);
	}

}
