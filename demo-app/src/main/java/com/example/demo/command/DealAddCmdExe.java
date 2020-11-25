package com.example.demo.command;

import com.alibaba.cola.dto.Response;
import com.example.demo.domain.aggregate.account.Account;
import com.example.demo.domain.aggregate.account.AccountOperationType;
import com.example.demo.domain.gateway.AccountGateway;
import com.example.demo.domain.aggregate.seedwork.BaseOperationType;
import com.example.demo.dto.DealAddCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DealAddCmdExe {
    @Resource
    private AccountGateway accountGateway;

    public Response execute(DealAddCmd cmd) {
        Account account = accountGateway.getAccountByAccountNo(cmd.getDealInfoCO().getAccountNo());
        account.setBaseInfo(cmd.getOperater(), BaseOperationType.UPDATE);
        switch (AccountOperationType.fromCode(cmd.getDealInfoCO().getAccountOperationTypeCode())){
            case DRAW_MONEY:
                account.drawMoney(cmd.getDealInfoCO().getAmount());
                break;
            case DEPOSIT_MONEY:
                account.depositMoney(cmd.getDealInfoCO().getAmount());
                break;
            default:
                break;
        }
        accountGateway.save(account);
        return Response.buildSuccess();
    }
}
