package com.cg.BankAppCollectionsParallel.Dao;

import com.cg.BankAppCollectionsParallel.model.CustomerDetails;
import com.cg.BankAppCollectionsParallel.model.TransactionDetails;

public interface BankTransactionsDAO {
	public long registration(CustomerDetails customerDetails);
	public boolean validation(String aadharNo);
	public CustomerDetails login(long accountNo,String password);
	public long withdraw(long accountNo,long amount);
	public long deposit(long accountNo,long amount);
	public long fundTransfer(TransactionDetails transactionDetails);
	
}
