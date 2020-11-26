package com.example.demo.service;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.example.demo.api.AccountService;
import com.example.demo.command.*;
import com.example.demo.command.query.CustomerFindAccountsQueryExe;
import com.example.demo.command.query.RemainingSumQueryExe;
import com.example.demo.dto.*;
import com.example.demo.dto.clientobject.AccountCO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountAddCmdExe accountAddCmdExe;
    @Resource
    private DrawMoneyCmdExe drawMoneyCmdExe;
    @Resource
    private DepositMoneyCmdExe depositMoneyCmdExe;
    @Resource
    private ConsumeMoneyCmdExe consumeMoneyCmdExe;
    @Resource
    private TransferMoneyCmdExe transferMoneyCmdExe;
    @Resource
    private RemainingSumQueryExe remainingSumQueryExe;
    @Resource
    private CustomerFindAccountsQueryExe customerFindAccountsQueryExe;

    @Override
    public Response addAccount(AccountAddCmd cmd) {
        return accountAddCmdExe.execute(cmd);
    }

    @Override
    public Response drawMoney(DrawMoneyCmd cmd) { return drawMoneyCmdExe.execute(cmd); }

    @Override
    public Response depositMoney(DepositMoneyCmd cmd) {
        return depositMoneyCmdExe.execute(cmd);
    }

    @Override
    public Response consumeMoney(ConsumeMoneyCmd cmd) {
        return consumeMoneyCmdExe.execute(cmd);
    }

    @Override
    public Response transferMoney(TransferMoneyCmd cmd) {
        return transferMoneyCmdExe.execute(cmd);
    }

    @Override
    public SingleResponse<Double> getRemainingSum(RemainingSumQuery query) {
        return remainingSumQueryExe.execute(query);
    }

    @Override
    public MultiResponse<AccountCO> getAccountsByCustomerId(CustomerFindAccountsQuery query) {
        return customerFindAccountsQueryExe.execute(query);
    }
}
