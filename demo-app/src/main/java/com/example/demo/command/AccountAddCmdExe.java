package com.example.demo.command;

import com.alibaba.cola.dto.Response;
import com.example.demo.domain.DomainFactory;
import com.example.demo.domain.aggregate.account.AccountType;
import com.example.demo.domain.aggregate.account.credit.CreditAccount;
import com.example.demo.domain.aggregate.account.debit.DebitAccount;
import com.example.demo.domain.aggregate.customer.Customer;
import com.example.demo.domain.gateway.AccountGateway;
import com.example.demo.domain.gateway.CustomerGateway;
import com.example.demo.dto.AccountAddCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

@Component
public class AccountAddCmdExe {
    @Resource
    private AccountGateway accountGateway;

    @Resource
    private CustomerGateway customerGateway;

    public Response execute(AccountAddCmd cmd) {
        Customer customer = customerGateway.getByCustomerId(cmd.getAccountCO().getCustomerId());
        switch (AccountType.fromCode(cmd.getAccountCO().getAccountType())){
            case DEBIT_ACCOUNT:
                DebitAccount debitAccount = DomainFactory.getDebitAccount();
                debitAccount.setAccountNo(cmd.getAccountCO().getAccountNo());
                debitAccount.setAccountType(AccountType.DEBIT_ACCOUNT);
                debitAccount.setRemainingSum(cmd.getAccountCO().getRemainingSum());
                debitAccount.setCreator(cmd.getOperater());
                debitAccount.setModifier(cmd.getOperater());
                debitAccount.setCreateTime(new Timestamp((new Date().getTime())));
                debitAccount.setModifiedTime(new Timestamp((new Date().getTime())));
                debitAccount.setCustomer(customer);
                accountGateway.save(debitAccount);
                break;
            case CREDIT_ACCOUNT:
                CreditAccount creditAccount = DomainFactory.getCreditAccount();
                creditAccount.setAccountNo(cmd.getAccountCO().getAccountNo());
                creditAccount.setAccountType(AccountType.CREDIT_ACCOUNT);
                creditAccount.setRemainingSum(cmd.getAccountCO().getRemainingSum());
                creditAccount.setBillDay(cmd.getAccountCO().getBillDay());
                creditAccount.setMaxCreditAmount(cmd.getAccountCO().getMaxCreditAmount());
                creditAccount.setMaxWithdrawalAmount(cmd.getAccountCO().getMaxWithdrawalAmount());
                creditAccount.setRepaymentDate(cmd.getAccountCO().getRepaymentDate());
                creditAccount.setCreator(cmd.getOperater());
                creditAccount.setModifier(cmd.getOperater());
                creditAccount.setCreateTime(new Timestamp((new Date().getTime())));
                creditAccount.setModifiedTime(new Timestamp((new Date().getTime())));
                creditAccount.setCustomer(customer);
                accountGateway.save(creditAccount);
                break;
            default:
                break;
        }
        return Response.buildSuccess();
    }
}
