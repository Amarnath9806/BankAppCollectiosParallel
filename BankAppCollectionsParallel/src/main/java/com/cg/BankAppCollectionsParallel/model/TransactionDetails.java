package com.cg.BankAppCollectionsParallel.model;

public class TransactionDetails {
	private long transactionId;
	private long fromAccountNo;
	private long toAccountNo;
	private long amount_transfered;
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public long getFromAccountNo() {
		return fromAccountNo;
	}
	public void setFromAccountNo(long fromAccountNo) {
		this.fromAccountNo = fromAccountNo;
	}
	public long getToAccountNo() {
		return toAccountNo;
	}
	public void setToAccountNo(long toAccountNo) {
		this.toAccountNo = toAccountNo;
	}
	public long getAmount_transfered() {
		return amount_transfered;
	}
	public void setAmount_transfered(long amount_transfered) {
		this.amount_transfered = amount_transfered;
	}
}
