package com.example.demo.command;

import com.alibaba.cola.dto.Response;
import com.example.demo.domain.aggregate.account.entity.Account;
import com.example.demo.domain.service.AccountDomainService;
import com.example.demo.domain.aggregate.account.entity.CreditAccount;
import com.example.demo.domain.seedwork.BaseOperationType;
import com.example.demo.domain.gateway.AccountGateway;
import com.example.demo.dto.ConsumeMoneyCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ConsumeMoneyCmdExe {

    @Resource
    private AccountDomainService accountDomainService;

    @Resource
    private AccountGateway accountGateway;

    public Response execute(ConsumeMoneyCmd cmd) {
//        Account payerAccount = accountGateway.getAccountByAccountNo(cmd.getPayer().getAccountNo());
        CreditAccount payerAccount = (CreditAccount) accountGateway.getAccountByAccountNo(cmd.getPayer().getAccountNo());
        Account payeeAccount = accountGateway.getAccountByAccountNo(cmd.getPayee().getAccountNo());
        payerAccount.setBaseInfo(cmd.getOperater(), BaseOperationType.UPDATE);
        payeeAccount.setBaseInfo(cmd.getOperater(), BaseOperationType.UPDATE);
        accountDomainService.consumeAccounts(payerAccount, payeeAccount, cmd.getAmount());
//        accountDomainService.consumeAccounts(payerAccount, payeeAccount, cmd.getAmount());
        accountGateway.save(payerAccount);
        accountGateway.save(payeeAccount);
        return Response.buildSuccess();
    }
}
