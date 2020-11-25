package com.example.demo.domain.aggregate.account.credit;

import com.example.demo.domain.aggregate.account.Account;
import com.example.demo.domain.aggregate.account.AccountOperationType;
import com.example.demo.domain.aggregate.account.Ledger;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class CreditAccount extends Account {

    private double maxCreditAmount; //最大信用额度
    private double currentMonthCreditSurplusAmount; //当月消费剩余额度
    private double maxWithdrawalAmount; //最大取现额度
    private double currentMonthWithdrawalSurplusAmount; //当月取现剩余额度

    private String BillDay; //账单日
    private String repaymentDate; //还款日期

    @Override
    public void consume(double amount) {
        if (remainingSum >= 0) {
            currentMonthCreditSurplusAmount = currentMonthCreditSurplusAmount + remainingSum - amount;
        }else {
            currentMonthCreditSurplusAmount = currentMonthCreditSurplusAmount - amount;
        }
        remainingSum -= amount;
        currentMonthCreditSurplusAmount = calculateCurrentMonthCreditSurplusAmount(currentMonthCreditSurplusAmount, amount);
        Ledger ledger = new Ledger(0 - amount, AccountOperationType.DRAW_MONEY);
        this.addLedger(ledger);
    }

    @Override
    public void drawMoney(double amount) {
        if (remainingSum >= 0) {
            currentMonthWithdrawalSurplusAmount = currentMonthWithdrawalSurplusAmount + remainingSum - amount;
        }else {
            currentMonthWithdrawalSurplusAmount = currentMonthWithdrawalSurplusAmount - amount;
        }
        remainingSum -= amount;
        currentMonthWithdrawalSurplusAmount = calculateCurrentMonthWithdrawalSurplusAmount(currentMonthCreditSurplusAmount, amount);
        Ledger ledger = new Ledger(0 - amount, AccountOperationType.DRAW_MONEY);
        this.addLedger(ledger);
    }

    @Override
    public void depositMoney(double amount) {
        remainingSum += amount;
        currentMonthWithdrawalSurplusAmount = currentMonthWithdrawalSurplusAmount + amount;
        currentMonthWithdrawalSurplusAmount = calculateCurrentMonthWithdrawalSurplusAmount(currentMonthCreditSurplusAmount, amount);
        Ledger ledger = new Ledger(amount, AccountOperationType.DEPOSIT_MONEY);
        this.addLedger(ledger);
    }

    private double calculateCurrentMonthWithdrawalSurplusAmount(double currentMonthWithdrawalSurplusAmount, double amount) {
        return currentMonthWithdrawalSurplusAmount > 0 ? 0 : currentMonthWithdrawalSurplusAmount;
    }

    private double calculateCurrentMonthCreditSurplusAmount(double currentMonthCreditSurplusAmount, double amount) {
        return currentMonthCreditSurplusAmount > 0 ? 0 : currentMonthCreditSurplusAmount;
    }

}
