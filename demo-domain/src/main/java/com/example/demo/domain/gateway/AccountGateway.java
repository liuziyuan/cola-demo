package com.example.demo.domain.gateway;

import com.example.demo.domain.aggregate.account.entity.Account;
import com.example.demo.domain.aggregate.account.repository.AccountRepository;

import java.util.List;

public interface AccountGateway extends AccountRepository {

    List<Account> AccountListByCustomerId(Long customerId);

}
