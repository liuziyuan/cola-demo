package com.example.demo.command;

import com.alibaba.cola.dto.Response;
import com.example.demo.domain.aggregate.account.AccountType;
import com.example.demo.domain.aggregate.account.entity.Account;
import com.example.demo.domain.aggregate.account.entity.CreditAccount;
import com.example.demo.domain.aggregate.account.entity.DebitAccount;
import com.example.demo.domain.gateway.AccountGateway;
import com.example.demo.domain.seedwork.BaseOperationType;
import com.example.demo.domain.service.AccountDomainService;
import com.example.demo.dto.TransferMoneyCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TransferMoneyCmdExe {

    @Resource
    private AccountDomainService accountDomainService;
    @Resource
    private AccountGateway accountGateway;

    public Response execute(TransferMoneyCmd cmd) {
        Account payerAccount = accountGateway.getAccountByAccountNo(cmd.getPayer().getAccountNo());
        Account payeeAccount = accountGateway.getAccountByAccountNo(cmd.getPayee().getAccountNo());
        payerAccount.setBaseInfo(cmd.getOperater(), BaseOperationType.UPDATE);
        payeeAccount.setBaseInfo(cmd.getOperater(), BaseOperationType.UPDATE);
        accountDomainService.transferAccounts(payerAccount, payeeAccount, cmd.getAmount());
        accountGateway.save(payerAccount);
        accountGateway.save(payeeAccount);
        return Response.buildSuccess();
    }
}
