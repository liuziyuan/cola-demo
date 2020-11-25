package com.example.demo.domain.aggregate.account;

import com.example.demo.domain.aggregate.account.credit.CreditAccount;

public interface AccountDomainService {

    void consumeAccounts(Account payer , Account payee, double amount);

    void consumeAccounts(CreditAccount payer, Account payee, double amount);
}
