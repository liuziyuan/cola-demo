package com.example.demo.domain.aggregate.account;

import com.example.demo.domain.aggregate.account.entity.CreditAccount;
import com.example.demo.domain.aggregate.account.factory.AccountFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreditAccountTest {
    private CreditAccount account;

    @Before
    public void setUp() {
        account = AccountFactory.getCreditAccount();
        account.setRemainingSum(0);
    }

    @Test
    public void testDepositMoneyWhenRemainingSumGt0() {
        account.setRemainingSum(500);
        account.setMaxCreditAmount(10000);
        account.setCurrentMonthCreditSurplusAmount(10000);
        account.setMaxWithdrawalAmount(5000);
        account.setCurrentMonthWithdrawalSurplusAmount(5000);
        account.depositMoney(500);
        Assert.assertTrue(account.getRemainingSum() == 1000);
        Assert.assertTrue(account.getCurrentMonthWithdrawalSurplusAmount() == 5000);
        Assert.assertTrue(account.getCurrentMonthCreditSurplusAmount() == 10000);
    }

    @Test
    public void testDepositMoneyLt0() {
        account.setRemainingSum(-3000);
        account.setMaxCreditAmount(10000);
        account.setCurrentMonthCreditSurplusAmount(7000);
        account.setMaxWithdrawalAmount(5000);
        account.setCurrentMonthWithdrawalSurplusAmount(2000);
        account.depositMoney(500);
        Assert.assertTrue(account.getRemainingSum() == -2500);
        Assert.assertTrue(account.getCurrentMonthWithdrawalSurplusAmount() == 2500);
        Assert.assertTrue(account.getCurrentMonthCreditSurplusAmount() == 7500);
    }

    @Test
    public void testDrawMoneyGt0() {
        account.setRemainingSum(500);
        account.setMaxCreditAmount(10000);
        account.setCurrentMonthCreditSurplusAmount(10000);
        account.setMaxWithdrawalAmount(5000);
        account.setCurrentMonthWithdrawalSurplusAmount(5000);
        account.drawMoney(200);
        Assert.assertTrue(account.getRemainingSum() == 300);
        Assert.assertTrue(account.getCurrentMonthWithdrawalSurplusAmount() == 5000);
        Assert.assertTrue(account.getCurrentMonthCreditSurplusAmount() == 10000);
    }

    @Test
    public void testDrawMoneyLt0() {
        account.setRemainingSum(-3000);
        account.setMaxCreditAmount(10000);
        account.setCurrentMonthCreditSurplusAmount(7000);
        account.setMaxWithdrawalAmount(5000);
        account.setCurrentMonthWithdrawalSurplusAmount(2000);
        account.drawMoney(500);
        Assert.assertTrue(account.getRemainingSum() == -3500);
        Assert.assertTrue(account.getCurrentMonthWithdrawalSurplusAmount() == 1500);
        Assert.assertTrue(account.getCurrentMonthCreditSurplusAmount() == 6500);
    }

    @Test
    public void testConsumeGt0() {
        account.setRemainingSum(500);
        account.setMaxCreditAmount(10000);
        account.setCurrentMonthCreditSurplusAmount(10000);
        account.setMaxWithdrawalAmount(5000);
        account.setCurrentMonthWithdrawalSurplusAmount(5000);
        account.consume(200);
        Assert.assertTrue(account.getRemainingSum() == 300);
        Assert.assertTrue(account.getCurrentMonthWithdrawalSurplusAmount() == 5000);
        Assert.assertTrue(account.getCurrentMonthCreditSurplusAmount() == 10000);
    }

    @Test
    public void testConsumeLt0() {
        account.setRemainingSum(-3000);
        account.setMaxCreditAmount(10000);
        account.setCurrentMonthCreditSurplusAmount(7000);
        account.setMaxWithdrawalAmount(5000);
        account.setCurrentMonthWithdrawalSurplusAmount(2000);
        account.consume(500);
        Assert.assertTrue(account.getRemainingSum() == -3500);
        Assert.assertTrue(account.getCurrentMonthWithdrawalSurplusAmount() == 1500);
        Assert.assertTrue(account.getCurrentMonthCreditSurplusAmount() == 6500);
    }
}
