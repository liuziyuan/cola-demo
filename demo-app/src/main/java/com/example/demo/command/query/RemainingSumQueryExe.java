package com.example.demo.command.query;

import com.alibaba.cola.dto.SingleResponse;
import com.example.demo.domain.aggregate.account.entity.Account;
import com.example.demo.domain.gateway.AccountGateway;
import com.example.demo.dto.RemainingSumQuery;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RemainingSumQueryExe {

    @Resource
    private AccountGateway accountGateway;

    public SingleResponse<Double> execute(RemainingSumQuery query) {
        Account account = accountGateway.getAccountByAccountNo(query.getAccountNo());
        double remainingSum = account.getRemainingSum();
        return SingleResponse.of(remainingSum);
    }
}
