package com.example.demo.command;

import com.alibaba.cola.dto.Response;
import com.example.demo.domain.aggregate.account.Account;
import com.example.demo.domain.aggregate.account.AccountDomainService;
import com.example.demo.domain.aggregate.account.credit.CreditAccount;
import com.example.demo.domain.aggregate.seedwork.BaseOperationType;
import com.example.demo.domain.gateway.AccountGateway;
import com.example.demo.dto.ConsumeAddCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ConsumeAddCmdExe {

    @Resource
    private AccountDomainService accountDomainService;

    @Resource
    private AccountGateway accountGateway;

    public Response execute(ConsumeAddCmd cmd) {
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
