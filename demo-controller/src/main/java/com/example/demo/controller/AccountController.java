package com.example.demo.controller;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.example.demo.api.AccountService;
import com.example.demo.dto.AccountAddCmd;
import com.example.demo.dto.ConsumeAddCmd;
import com.example.demo.dto.DealAddCmd;
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
    public Response drawMoney(@RequestBody DealAddCmd dealAddCmd){
        return accountService.drawMoney(dealAddCmd);
    }

    @PostMapping(value = "/depositMoney")
    public Response depositMoney(@RequestBody DealAddCmd dealAddCmd){
        return accountService.depositMoney(dealAddCmd);
    }

    @PostMapping(value = "/consumeMoney")
    public Response consumeMoney(@RequestBody ConsumeAddCmd consumeAddCmd){
        return accountService.consumeMoney(consumeAddCmd);
    }
}
