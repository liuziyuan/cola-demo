package com.example.demo.api;

import com.alibaba.cola.dto.Response;
import com.example.demo.dto.*;

public interface AccountService {
    Response addAccount(AccountAddCmd cmd);

    Response drawMoney(DrawMoneyCmd cmd);

    Response depositMoney(DepositMoneyCmd cmd);

    Response consumeMoney(ConsumeMoneyCmd cmd);

    Response transferMoney(TransferMoneyCmd cmd);
}
