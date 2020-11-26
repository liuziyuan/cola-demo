package com.example.demo.command.query;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.SingleResponse;
import com.example.demo.domain.aggregate.account.entity.Account;
import com.example.demo.domain.gateway.AccountGateway;
import com.example.demo.dto.CustomerFindAccountsQuery;
import com.example.demo.dto.RemainingSumQuery;
import com.example.demo.dto.clientobject.AccountCO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerFindAccountsQueryExe {

    @Resource
    private AccountGateway accountGateway;

    public MultiResponse<AccountCO> execute(CustomerFindAccountsQuery query) {
        List<AccountCO> accountCOList = new ArrayList<>();
        List<Account> accounts = accountGateway.AccountListByCustomerId(query.getCustomerId());
        AccountCO accountCO;
        for (Account account : accounts) {
            accountCO = new AccountCO();
            BeanUtils.copyProperties(account , accountCO);
            accountCOList.add(accountCO);
        }
        return MultiResponse.ofWithoutTotal(accountCOList);
    }
}
