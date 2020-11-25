package com.example.demo.gatewayimpl.database.repository;

import com.example.demo.domain.aggregate.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAccountsByCustomer(Long id);

    Account getAccountByAccountNo(String accountNo);

}
