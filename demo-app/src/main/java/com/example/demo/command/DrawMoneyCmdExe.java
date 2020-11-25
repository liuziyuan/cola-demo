package com.example.demo.command;

import com.alibaba.cola.dto.Response;
import com.example.demo.domain.aggregate.account.entity.Account;
import com.example.demo.domain.gateway.AccountGateway;
import com.example.demo.domain.seedwork.BaseOperationType;
import com.example.demo.dto.DrawMoneyCmd;

import javax.annotation.Resource;

public class DrawMoneyCmdExe {
    @Resource
    private AccountGateway accountGateway;

    public Response execute(DrawMoneyCmd cmd) {
        Account account = accountGateway.getAccountByAccountNo(cmd.getTransactionCO().getAccountNo());
        account.setBaseInfo(cmd.getOperater(), BaseOperationType.UPDATE);
        account.drawMoney(cmd.getTransactionCO().getAmount());
        accountGateway.save(account);
        return Response.buildSuccess();
    }
}
