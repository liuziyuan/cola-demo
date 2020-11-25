package com.example.demo.domain.aggregate.account.entity;

import com.example.demo.domain.aggregate.account.AccountOperationType;
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
        currentMonthCreditSurplusAmount = calculateCurrentMonthCreditSurplusAmount(currentMonthCreditSurplusAmount, remainingSum, amount, AccountOperationType.CONSUME_MONEY);
        remainingSum = calculateRemainingSum(remainingSum, amount, AccountOperationType.CONSUME_MONEY);
        Ledger ledger = new Ledger(0 - amount, AccountOperationType.CONSUME_MONEY);
        addLedger(ledger);
    }

    @Override
    public void drawMoney(double amount) {
        currentMonthWithdrawalSurplusAmount = calculateCurrentMonthWithdrawalSurplusAmount(currentMonthWithdrawalSurplusAmount, remainingSum, amount, AccountOperationType.DRAW_MONEY);
        remainingSum = calculateRemainingSum(remainingSum, amount, AccountOperationType.DRAW_MONEY);
        Ledger ledger = new Ledger(0 - amount, AccountOperationType.DRAW_MONEY);
        addLedger(ledger);
    }

    @Override
    public void depositMoney(double amount) {
        currentMonthWithdrawalSurplusAmount = calculateCurrentMonthWithdrawalSurplusAmount(currentMonthWithdrawalSurplusAmount, remainingSum, amount, AccountOperationType.DEPOSIT_MONEY);
        remainingSum = calculateRemainingSum(remainingSum, amount, AccountOperationType.DEPOSIT_MONEY);
        Ledger ledger = new Ledger(amount, AccountOperationType.DEPOSIT_MONEY);
        addLedger(ledger);
    }

    public double calculateCurrentMonthWithdrawalSurplusAmount(double currentMonthWithdrawalSurplusAmountValue, double remainingSumValue, double amount, AccountOperationType type) {
        switch (type) {
            case DEPOSIT_MONEY:
                currentMonthWithdrawalSurplusAmountValue += amount;
                currentMonthWithdrawalSurplusAmountValue = getRealCurrentMonthWithdrawalSurplusAmount(currentMonthWithdrawalSurplusAmountValue);
                break;
            case DRAW_MONEY:
                if (remainingSumValue >= 0) {
                    currentMonthWithdrawalSurplusAmountValue = currentMonthWithdrawalSurplusAmountValue + remainingSumValue - amount;
                } else {
                    currentMonthWithdrawalSurplusAmountValue -= amount;
                }
                currentMonthWithdrawalSurplusAmountValue = getRealCurrentMonthWithdrawalSurplusAmount(currentMonthWithdrawalSurplusAmountValue);
                break;
            case CONSUME_MONEY:
                break;
        }
        return currentMonthWithdrawalSurplusAmountValue;
    }

    public double calculateCurrentMonthCreditSurplusAmount(double currentMonthCreditSurplusAmountValue, double remainingSumValue, double amount, AccountOperationType type) {
        switch (type) {
            case DEPOSIT_MONEY:
            case DRAW_MONEY:
                break;
            case CONSUME_MONEY:
                if (remainingSumValue >= 0) {
                    currentMonthCreditSurplusAmountValue = currentMonthCreditSurplusAmountValue + remainingSumValue - amount;
                } else {
                    currentMonthCreditSurplusAmountValue -= amount;
                }
                currentMonthCreditSurplusAmountValue = getRealCurrentMonthCreditSurplusAmount(currentMonthCreditSurplusAmountValue);
                break;
        }
        return currentMonthCreditSurplusAmountValue;
    }

    private double getRealCurrentMonthWithdrawalSurplusAmount(double currentMonthWithdrawalSurplusAmount) {
        return currentMonthWithdrawalSurplusAmount > 0 ? 0 : currentMonthWithdrawalSurplusAmount;
    }

    private double getRealCurrentMonthCreditSurplusAmount(double currentMonthCreditSurplusAmount) {
        return currentMonthCreditSurplusAmount > 0 ? 0 : currentMonthCreditSurplusAmount;
    }

}
