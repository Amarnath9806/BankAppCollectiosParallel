package com.cg.BankAppCollectionsParallel.MainUI;

import java.util.Scanner;

import javax.imageio.spi.RegisterableService;

import com.cg.BankAppCollectionsParallel.model.CustomerDetails;
import com.cg.BankAppCollectionsParallel.model.TransactionDetails;
import com.cg.BankAppCollectionsParallel.service.BankTransactionsService;
import com.cg.BankAppCollectionsParallel.service.BankTransactionsServiceImpl;
import com.cg.BankAppCollectionsParallel.utility.InvalidAadhaarNoException;
import com.cg.BankAppCollectionsParallel.utility.WrongLoginCredentialsException;
import com.cg.BankAppCollectionsParallel.utility.InvalidMobileNoException;

public class MainUI {
	public static void main(String[] args) {

		long balance;
		Scanner sc = new Scanner(System.in);
		BankTransactionsServiceImpl serviceValidation = new BankTransactionsServiceImpl();
		BankTransactionsService transactionService = new BankTransactionsServiceImpl();
		TransactionDetails transactionDetails = new TransactionDetails();
		int i;
		do {
			// Showing the menu here
			System.out.println("Enter 1 for Registration 2 for login");
			System.out.println("1. Registration");
			System.out.println("2. Login");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				CustomerDetails customerDetails = new CustomerDetails();
				// Scanning the customer details for registartion
				System.out.println("Enter firstname");
				customerDetails.setFirstname(sc.next());
				System.out.println("Enter lastname");
				customerDetails.setLastname(sc.next());
				System.out.println("Enter Email");
				customerDetails.setEmail(sc.next());
				System.out.println("Enter password");
				customerDetails.setPassword(sc.next());
				System.out.println("Enter pan no");
				customerDetails.setPanNo(sc.next());
				System.out.println("Enter aadhar");
				customerDetails.setAadharCardNo(sc.next());
				if (transactionService.validation(customerDetails.getAadharCardNo())) {
					System.out.println("Enter address");
					customerDetails.setAddress(sc.next());
					System.out.println("Enter mobile number");
					String mobileNo = sc.next();
					if (serviceValidation.validateNumber(mobileNo)) {
						customerDetails.setMobileNo(mobileNo);
						customerDetails.setBalance(0);
						System.out.println("Account number is " + transactionService.registration(customerDetails));
					} else {
						try {
							throw new InvalidMobileNoException();
						} catch (InvalidMobileNoException e) {
						}
					}
				} else {
					try {
						throw new InvalidAadhaarNoException();
					} catch (InvalidAadhaarNoException e) {
					}
				}
				break;
			case 2:
				CustomerDetails customerDetails2 = new CustomerDetails();
				System.out.println("Enter account number");
				customerDetails2.setAccountNo(sc.nextLong());
				System.out.println("Enter password");
				customerDetails2.setPassword(sc.next());
				customerDetails2 = transactionService.login(customerDetails2.getAccountNo(), customerDetails2.getPassword());
				menu: while (true) {
					if (customerDetails2.getAccountNo() > 0) {
						System.out.println("Welcome " + customerDetails2.getFirstname());
						System.out.println("Enter your choice");
						System.out.println("1. Deposit");
						System.out.println("2. Withdraw");
						System.out.println("3. Show balance");
						System.out.println("4. Fund transfer");
						System.out.println("5. Exit");
						choice = sc.nextInt();
						switch (choice) {
						case 1:
							System.out.println("Enter amount for deposit");
							long amount=sc.nextLong();
							balance = transactionService.deposit(customerDetails2.getAccountNo(),amount );
							System.out.println("Updated balance: " + balance);
							break;
						case 2:
							System.out.println("Enter amount for withdrawal");
							long amount1=sc.nextLong();
							balance = transactionService.withdraw(customerDetails2.getAccountNo(), amount1);
							System.out.println("Updated balance: " + balance);
							break;
						case 3:
							System.out.println("Balance is " + customerDetails2.getBalance());
							break;
						case 4:
							System.out.println("Enter account number to transfer");
							transactionDetails.setToAccountNo(sc.nextLong());
							System.out.println("Enter amount to tranfer");
							transactionDetails.setAmount_transfered(sc.nextLong());
							transactionDetails.setFromAccountNo(customerDetails2.getAccountNo());
							long trans_id = transactionService.fundTransfer(transactionDetails);
							if (trans_id > 0) {
								System.out.println("Amount of Rs." + transactionDetails.getAmount_transfered()
										+ " tranfered from account number " + transactionDetails.getFromAccountNo()
										+ " to account number " + transactionDetails.getToAccountNo());
								System.out.println("Transaction id:" + trans_id);
							}
							break;
						case 5:
							System.out.println("Thank you!");
							break menu;
						default:
							System.out.println("Enter valid input");
							break;

						}
					} else {
						try {
							throw new WrongLoginCredentialsException();
						} catch (WrongLoginCredentialsException e) {
						break;
						}
						
					}

				}
				break;
			default:
				System.out.println("Enter valid input.");
				break;
			}
			System.out.println("Enter 1 to continue or press any other number to exit.");
			i = sc.nextInt();
		} while (i == 1);
		System.out.println("Thank you");
	}
}