package com.cg.BankAppCollectionsParallel.service;

import com.cg.BankAppCollectionsParallel.model.CustomerDetails;
import com.cg.BankAppCollectionsParallel.model.TransactionDetails;

public interface BankTransactionsService {
		long registration(CustomerDetails customerDetails);
		boolean validation(String string);
		public CustomerDetails login(long accountNo,String password);
		public long withdraw(long accountNo,long amount);
		public long deposit(long accountNo,long amount);
		public long fundTransfer(TransactionDetails transactionDetails);
		
}
