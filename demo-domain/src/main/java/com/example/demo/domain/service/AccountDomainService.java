package com.example.demo.domain.service;

import com.example.demo.domain.aggregate.account.entity.CreditAccount;
import com.example.demo.domain.aggregate.account.entity.Account;

public interface AccountDomainService {

    void consumeAccounts(Account payer , Account payee, double amount);

    void consumeAccounts(CreditAccount payer, Account payee, double amount);
}
