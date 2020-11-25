package com.example.demo.command;

import com.alibaba.cola.dto.Response;
import com.example.demo.domain.aggregate.account.entity.Account;
import com.example.demo.domain.gateway.AccountGateway;
import com.example.demo.domain.seedwork.BaseOperationType;
import com.example.demo.dto.DepositMoneyCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DepositMoneyCmdExe {
    @Resource
    private AccountGateway accountGateway;

    public Response execute(DepositMoneyCmd cmd) {
        Account account = accountGateway.getAccountByAccountNo(cmd.getTransactionCO().getAccountNo());
        account.setBaseInfo(cmd.getOperater(), BaseOperationType.UPDATE);
        account.depositMoney(cmd.getTransactionCO().getAmount());
        accountGateway.save(account);
        return Response.buildSuccess();
    }
}
