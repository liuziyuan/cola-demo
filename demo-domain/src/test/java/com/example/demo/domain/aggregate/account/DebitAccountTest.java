package com.example.demo.domain.aggregate.account;

import com.example.demo.domain.aggregate.account.entity.DebitAccount;
import com.example.demo.domain.aggregate.account.factory.AccountFactory;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DebitAccountTest {
    private DebitAccount account;

    @Before
    public void setUp() {
        account = AccountFactory.getDebitAccount();
        account.setRemainingSum(0);
    }

    @Test
    public void testDepositMoney() {
        account.setRemainingSum(0);
        account.depositMoney(500);
        Assert.assertTrue(account.getRemainingSum() == 500);
    }

    @Test
    public void testDrawMoney() {
        account.setRemainingSum(500);
        account.drawMoney(200);
        Assert.assertTrue(account.getRemainingSum() == 300);
    }

    @Test
    public void testConsume() {
        account.setRemainingSum(500);
        account.consume(200);
        Assert.assertTrue(account.getRemainingSum() == 300);

    }
}
