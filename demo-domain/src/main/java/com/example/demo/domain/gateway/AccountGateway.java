package com.example.demo.domain.gateway;

import com.example.demo.domain.aggregate.account.Account;

import java.util.List;

public interface AccountGateway {
    void save(Account account);

    List<Account> AccountListByCustomerId(Long customerId);

    Account getAccountByAccountNo(String accountNo);

}
