package com.example.demo.api;

import com.alibaba.cola.dto.Response;
import com.example.demo.dto.AccountAddCmd;
import com.example.demo.dto.ConsumeMoneyCmd;
import com.example.demo.dto.DepositMoneyCmd;
import com.example.demo.dto.DrawMoneyCmd;

public interface AccountService {
    Response addAccount(AccountAddCmd cmd);

    Response drawMoney(DrawMoneyCmd cmd);

    Response depositMoney(DepositMoneyCmd cmd);

    Response consumeMoney(ConsumeMoneyCmd cmd);
}
