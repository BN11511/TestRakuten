package com.priceminister.account;


import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.*;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {
    
    private Account customerAccount;
    private AccountRule rule;

    @Before
    public void setUp() {
        customerAccount = new CustomerAccount();
        rule = new CustomerAccountRule();
    }
    
    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        assertEquals(0.0, customerAccount.getBalance(), 0);
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
        double addAmount = 123456.0;
        customerAccount.add(addAmount);
        assertEquals(addAmount, customerAccount.getBalance(), 0);

    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Test (expected = IllegalBalanceException.class)
    public void testWithdrawAndReportBalanceIllegalBalance() throws IllegalBalanceException{
        double addAmount = 12345.0;
        double withdrawnValue = 23456.0;
        double withdrawPermitted = 1000.0;

        rule.withdrawPermitted(withdrawPermitted);
        customerAccount.add(addAmount);

        customerAccount.withdrawAndReportBalance(withdrawnValue,rule);

    }
    
    // Also implement missing unit tests for the above functionalities.
    /**
     * Withdraw money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testWithdrawAndReportBalanceLegalBalance() throws IllegalBalanceException {
        double addAmount = 22345.0;
        double withdrawnValue = 13456.0;
        double withdrawPermitted = 10.0;

        rule.withdrawPermitted(withdrawPermitted);
        customerAccount.add(addAmount);
        customerAccount.withdrawAndReportBalance(withdrawnValue,rule);

        assertEquals(addAmount - withdrawnValue, customerAccount.getBalance(), 0);

    }

}
