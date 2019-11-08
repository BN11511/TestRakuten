package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

    private double balance;

    public void add(Double addedAmount) {
        balance = balance + addedAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule)
    		throws IllegalBalanceException {
        balance = balance - withdrawnAmount;

        if (!rule.withdrawPermitted(balance)) {
            throw new IllegalBalanceException(balance);
        }

        return balance;
    }

}
