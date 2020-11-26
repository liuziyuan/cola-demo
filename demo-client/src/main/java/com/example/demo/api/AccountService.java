package com.example.demo.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.example.demo.dto.*;
import com.example.demo.dto.clientobject.AccountCO;

public interface AccountService {
    Response addAccount(AccountAddCmd cmd);

    Response drawMoney(DrawMoneyCmd cmd);

    Response depositMoney(DepositMoneyCmd cmd);

    Response consumeMoney(ConsumeMoneyCmd cmd);

    Response transferMoney(TransferMoneyCmd cmd);

    SingleResponse<Double> getRemainingSum(RemainingSumQuery query);

    MultiResponse<AccountCO> getAccountsByCustomerId(CustomerFindAccountsQuery query);
}
