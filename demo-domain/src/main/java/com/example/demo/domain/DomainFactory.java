package com.example.demo.domain;

import com.example.demo.domain.aggregate.account.AccountType;
import com.example.demo.domain.aggregate.account.credit.CreditAccount;
import com.example.demo.domain.aggregate.account.debit.DebitAccount;
import com.example.demo.domain.aggregate.customer.Address;
import com.example.demo.domain.aggregate.customer.Customer;
import com.example.demo.domain.aggregate.customer.IdentityCard;

import java.util.ArrayList;

public class DomainFactory {
    public static Customer getCustomer() {
        Customer customer = new Customer();
        IdentityCard identityCard = new IdentityCard();
        Address address = new Address();
        identityCard.setAddress(address);
        customer.setIdInfo(identityCard);
        return customer;
    }

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
