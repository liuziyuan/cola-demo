package com.example.demo.controller;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.example.demo.api.AccountService;
import com.example.demo.dto.*;
import com.example.demo.dto.clientobject.AccountCO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/transferMoney")
    public Response transferMoney(@RequestBody TransferMoneyCmd transferMoneyCmd){
        return accountService.transferMoney(transferMoneyCmd);
    }

    @GetMapping(value = "/remainingSum")
    public SingleResponse<Double> getAccountRemainingSum(RemainingSumQuery remainingSumQuery){
        return accountService.getRemainingSum(remainingSumQuery);
    }
    @GetMapping(value = "/")
    public MultiResponse<AccountCO> getAccountsByCustomerId(CustomerFindAccountsQuery customerFindAccountsQuery){
        return accountService.getAccountsByCustomerId(customerFindAccountsQuery);
    }
}
