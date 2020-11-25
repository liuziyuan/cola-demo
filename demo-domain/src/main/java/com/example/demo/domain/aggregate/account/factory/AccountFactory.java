package com.example.demo.domain.aggregate.account.factory;

import com.example.demo.domain.aggregate.account.AccountType;
import com.example.demo.domain.aggregate.account.entity.CreditAccount;
import com.example.demo.domain.aggregate.account.entity.DebitAccount;

import java.util.ArrayList;

public class AccountFactory {
    public static CreditAccount getCreditAccount() {
        CreditAccount creditAccount = new CreditAccount();
        creditAccount.setLedgers(new ArrayList<>());
        creditAccount.setAccountType(AccountType.CREDIT_ACCOUNT);
        return creditAccount;
    }

    public static DebitAccount getDebitAccount() {
        DebitAccount account = new DebitAccount();
        account.setLedgers(new ArrayList<>());
        account.setAccountType(AccountType.DEBIT_ACCOUNT);
        return account;
    }
}
