package com.example.demo.api;

import com.alibaba.cola.dto.Response;
import com.example.demo.dto.AccountAddCmd;
import com.example.demo.dto.ConsumeAddCmd;
import com.example.demo.dto.DealAddCmd;

public interface AccountService {
    Response addAccount(AccountAddCmd cmd);

    Response drawMoney(DealAddCmd cmd);

    Response depositMoney(DealAddCmd cmd);

    Response consumeMoney(ConsumeAddCmd cmd);
}
