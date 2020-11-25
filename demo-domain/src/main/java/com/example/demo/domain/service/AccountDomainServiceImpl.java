package com.example.demo.domain.service;

import com.example.demo.domain.aggregate.account.entity.Account;
import com.example.demo.domain.aggregate.account.entity.CreditAccount;
import org.springframework.stereotype.Component;

@Component
public class AccountDomainServiceImpl implements AccountDomainService {

    @Override
    public void consumeAccounts(Account payer, Account payee, double amount) {
        payer.consume(amount);
        payee.depositMoney(amount);
    }

    @Override
    public void consumeAccounts(CreditAccount payer, Account payee, double amount) {
        payer.consume(amount);
        payee.depositMoney(amount);
    }
}
