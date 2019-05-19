package com.cg.BankAppCollectionsParallel.DaoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.BankAppCollectionsParallel.Dao.BankTransactionsDAO;
import com.cg.BankAppCollectionsParallel.Dao.BankTransactionsDAOImpl;
import com.cg.BankAppCollectionsParallel.model.CustomerDetails;
import com.cg.BankAppCollectionsParallel.model.TransactionDetails;

class BankFunctionsDAOTest {

static BankTransactionsDAO dao;

@BeforeAll
public static void init() {
dao=new BankTransactionsDAOImpl();
}


@Test
void testRegistration() {
	CustomerDetails customerDetails=new CustomerDetails();
	customerDetails.setFirstname("amar");
	customerDetails.setLastname("amar");
	customerDetails.setAadharCardNo("123412391235");
	customerDetails.setAddress("hyd");
	customerDetails.setBalance(100);
	customerDetails.setEmail("amar@gmil.com");
	customerDetails.setMobileNo("72859990009");
	customerDetails.setPanNo("45rtgh6");
	customerDetails.setPassword("amar");
	assertEquals(1000000,dao.registration(customerDetails));
}
@Test
public void testLogin() {
CustomerDetails customerDetails=dao.login(1000000, "amar");
assertEquals(-1, customerDetails.getAccountNo());
}
@Test
public void testValidation() {
assertEquals(true, dao.validation("123412391235"));
}

@Test
public void testWithdraw() {
assertEquals(50, dao.withdraw(1000000,50));
}

@Test
public void testDeposit() {
assertEquals(100, dao.deposit(1000000, 50));
}

@Test
public void testFundTransfer() {
TransactionDetails details=new TransactionDetails();
details.setFromAccountNo(128);
details.setToAccountNo(127);
details.setAmount_transfered(-1000);
assertEquals(-1,dao.fundTransfer(details));
}

}