package com.example.demo.gatewayimpl;

import com.example.demo.domain.aggregate.account.entity.Account;
import com.example.demo.domain.gateway.AccountGateway;
import com.example.demo.gatewayimpl.database.repository.AccountRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class AccountGatewayImpl implements AccountGateway {

    @Resource
    private AccountRepository accountRepository;

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Account> AccountListByCustomerId(Long customerId) {
        return accountRepository.findAccountsByCustomer(customerId);
    }

    @Override
    public Account getAccountByAccountNo(String accountNo) {
        return accountRepository.getAccountByAccountNo(accountNo);
    }

}
