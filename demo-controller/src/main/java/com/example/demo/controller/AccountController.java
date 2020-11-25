package com.example.demo.controller;

import com.alibaba.cola.dto.Response;
import com.example.demo.api.AccountService;
import com.example.demo.dto.AccountAddCmd;
import com.example.demo.dto.ConsumeMoneyCmd;
import com.example.demo.dto.DepositMoneyCmd;
import com.example.demo.dto.DrawMoneyCmd;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api
@Slf4j
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    @Resource
    private AccountService accountService;

    @PostMapping(value = "/")
    public Response addAccount(@RequestBody AccountAddCmd accountAddCmd){
        return accountService.addAccount(accountAddCmd);
    }

    @PostMapping(value = "/drawMoney")
    public Response drawMoney(@RequestBody DrawMoneyCmd drawMoneyCmd){
        return accountService.drawMoney(drawMoneyCmd);
    }

    @PostMapping(value = "/depositMoney")
    public Response depositMoney(@RequestBody DepositMoneyCmd depositMoneyCmd){
        return accountService.depositMoney(depositMoneyCmd);
    }

    @PostMapping(value = "/consumeMoney")
    public Response consumeMoney(@RequestBody ConsumeMoneyCmd consumeMoneyCmd){
        return accountService.consumeMoney(consumeMoneyCmd);
    }
}
