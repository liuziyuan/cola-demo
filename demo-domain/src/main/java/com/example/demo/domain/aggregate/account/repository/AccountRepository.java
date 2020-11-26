package com.example.demo.domain.aggregate.account.repository;

import com.example.demo.domain.aggregate.account.entity.Account;

public interface AccountRepository {
    void save(Account account);
    Account getAccountByAccountNo(String accountNo);
}
