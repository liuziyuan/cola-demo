package com.example.demo.domain.service;

import com.example.demo.domain.aggregate.account.entity.CreditAccount;
import com.example.demo.domain.aggregate.account.entity.Account;
import com.example.demo.domain.aggregate.account.entity.DebitAccount;

public interface AccountDomainService {

    /** 信用卡消费
     * @param payer 信用卡消费账户
     * @param payee 收款账户
     * @param amount 交易金额
     */
    void consumeAccounts(CreditAccount payer, Account payee, double amount);

    /** 转账业务
     * @param payer 付款账户
     * @param payee 收款账户
     * @param amount 交易金额
     */
    void transferAccounts(Account payer, Account payee, double amount);

}
