package com.example.demo.domain.service;

import com.example.demo.domain.aggregate.account.entity.Account;
import com.example.demo.domain.aggregate.account.entity.CreditAccount;
import com.example.demo.domain.aggregate.account.entity.DebitAccount;
import org.springframework.stereotype.Component;

@Component
public class AccountDomainServiceImpl implements AccountDomainService {

    @Override
    public void consumeAccounts(CreditAccount payer, Account payee, double amount) {
        payer.consume(amount);
        payee.depositMoney(amount);
    }

    @Override
    public void transferAccounts(DebitAccount payer, Account payee, double amount) {
        payer.drawMoney(amount);
        payee.depositMoney(amount);
    }

    @Override
    public void transferAccounts(CreditAccount payer, Account payee, double amount) {
        payer.drawMoney(amount);
        payee.depositMoney(amount);
    }
}
