package com.example.demo.domain.aggregate.account;

import com.example.demo.domain.aggregate.account.entity.CreditAccount;
import com.example.demo.domain.aggregate.account.entity.DebitAccount;
import com.example.demo.domain.aggregate.account.factory.AccountFactory;
import org.junit.Assert;
import org.junit.Test;

public class AccountFactoryTest {


    @Test
    public void testGetDebitAccount(){
        DebitAccount account = AccountFactory.getDebitAccount();
        Assert.assertTrue(account.getLedgers() != null);
        Assert.assertTrue(account.getAccountType().equals(AccountType.DEBIT_ACCOUNT));
    }

    @Test
    public void testGetCreditAccount(){
        CreditAccount account = AccountFactory.getCreditAccount();
        Assert.assertTrue(account.getLedgers() != null);
        Assert.assertTrue(account.getAccountType().equals(AccountType.CREDIT_ACCOUNT));
    }
}
