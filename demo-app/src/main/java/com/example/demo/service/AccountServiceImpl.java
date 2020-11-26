package com.example.demo.service;

import com.alibaba.cola.dto.Response;
import com.example.demo.api.AccountService;
import com.example.demo.command.*;
import com.example.demo.dto.*;
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
}
