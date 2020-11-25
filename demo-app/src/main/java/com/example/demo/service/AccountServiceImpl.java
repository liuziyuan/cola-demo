package com.example.demo.service;

import com.alibaba.cola.dto.Response;
import com.example.demo.api.AccountService;
import com.example.demo.command.AccountAddCmdExe;
import com.example.demo.command.ConsumeAddCmdExe;
import com.example.demo.command.DealAddCmdExe;
import com.example.demo.dto.AccountAddCmd;
import com.example.demo.dto.ConsumeAddCmd;
import com.example.demo.dto.DealAddCmd;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountAddCmdExe accountAddCmdExe;

    @Resource
    private DealAddCmdExe dealAddCmdExe;

    @Resource
    private ConsumeAddCmdExe consumeAddCmdExe;

    @Override
    public Response addAccount(AccountAddCmd cmd) {
        return accountAddCmdExe.execute(cmd);
    }

    @Override
    public Response drawMoney(DealAddCmd cmd) {
        return dealAddCmdExe.execute(cmd);
    }

    @Override
    public Response depositMoney(DealAddCmd cmd) {
        return dealAddCmdExe.execute(cmd);
    }

    @Override
    public Response consumeMoney(ConsumeAddCmd cmd) {
        return consumeAddCmdExe.execute(cmd);
    }
}
