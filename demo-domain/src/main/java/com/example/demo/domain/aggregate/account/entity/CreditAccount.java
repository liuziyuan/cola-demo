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
        currentMonthWithdrawalSurplusAmount = calculateCurrentMonthWithdrawalSurplusAmount(currentMonthWithdrawalSurplusAmount, remainingSum, amount, AccountOperationType.CONSUME_MONEY);
        currentMonthCreditSurplusAmount = calculateCurrentMonthCreditSurplusAmount(currentMonthCreditSurplusAmount, remainingSum, amount, AccountOperationType.CONSUME_MONEY);
        remainingSum = calculateRemainingSum(remainingSum, amount, AccountOperationType.CONSUME_MONEY);
        Ledger ledger = new Ledger(0 - amount, AccountOperationType.CONSUME_MONEY);
        addLedger(ledger);
    }

    @Override
    public void drawMoney(double amount) {
        currentMonthWithdrawalSurplusAmount = calculateCurrentMonthWithdrawalSurplusAmount(currentMonthWithdrawalSurplusAmount, remainingSum, amount, AccountOperationType.DRAW_MONEY);
        currentMonthCreditSurplusAmount = calculateCurrentMonthCreditSurplusAmount(currentMonthCreditSurplusAmount, remainingSum, amount, AccountOperationType.DRAW_MONEY);
        remainingSum = calculateRemainingSum(remainingSum, amount, AccountOperationType.DRAW_MONEY);
        Ledger ledger = new Ledger(0 - amount, AccountOperationType.DRAW_MONEY);
        addLedger(ledger);
    }

    @Override
    public void depositMoney(double amount) {
        currentMonthWithdrawalSurplusAmount = calculateCurrentMonthWithdrawalSurplusAmount(currentMonthWithdrawalSurplusAmount, remainingSum, amount, AccountOperationType.DEPOSIT_MONEY);
        currentMonthCreditSurplusAmount = calculateCurrentMonthCreditSurplusAmount(currentMonthCreditSurplusAmount, remainingSum, amount, AccountOperationType.DEPOSIT_MONEY);
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
                // 取现产生手续费,演示忽略此逻辑
                if (remainingSumValue >= 0){
                    currentMonthWithdrawalSurplusAmountValue = currentMonthWithdrawalSurplusAmountValue + remainingSumValue - amount;
                }else {
                    currentMonthWithdrawalSurplusAmountValue = currentMonthWithdrawalSurplusAmountValue - amount;
                }
                currentMonthWithdrawalSurplusAmountValue = getRealCurrentMonthWithdrawalSurplusAmount(currentMonthWithdrawalSurplusAmountValue);
                break;
            case CONSUME_MONEY:
                if (remainingSumValue >= 0){
                    currentMonthWithdrawalSurplusAmountValue = currentMonthWithdrawalSurplusAmountValue + remainingSumValue - amount;
                }else {
                    currentMonthWithdrawalSurplusAmountValue = currentMonthWithdrawalSurplusAmountValue - amount;
                }
                currentMonthWithdrawalSurplusAmountValue = getRealCurrentMonthWithdrawalSurplusAmount(currentMonthWithdrawalSurplusAmountValue);
                break;
        }
        return currentMonthWithdrawalSurplusAmountValue;
    }

    public double calculateCurrentMonthCreditSurplusAmount(double currentMonthCreditSurplusAmountValue, double remainingSumValue, double amount, AccountOperationType type) {
        switch (type) {
            case DEPOSIT_MONEY:
                currentMonthCreditSurplusAmountValue += amount;
                currentMonthCreditSurplusAmountValue = getRealCurrentMonthCreditSurplusAmount(currentMonthCreditSurplusAmountValue);
                break;
            case DRAW_MONEY:
                // 取现产生手续费,演示忽略此逻辑
                if (remainingSumValue >= 0){
                    currentMonthCreditSurplusAmountValue = currentMonthCreditSurplusAmountValue + remainingSumValue - amount;
                }else {
                    currentMonthCreditSurplusAmountValue = currentMonthCreditSurplusAmountValue - amount;
                }
                currentMonthCreditSurplusAmountValue = getRealCurrentMonthCreditSurplusAmount(currentMonthCreditSurplusAmountValue);
                break;
            case CONSUME_MONEY:
                if (remainingSumValue >= 0){
                    currentMonthCreditSurplusAmountValue = currentMonthCreditSurplusAmountValue + remainingSumValue - amount;
                }else {
                    currentMonthCreditSurplusAmountValue = currentMonthCreditSurplusAmountValue - amount;
                }
                currentMonthCreditSurplusAmountValue = getRealCurrentMonthCreditSurplusAmount(currentMonthCreditSurplusAmountValue);
                break;
        }
        return currentMonthCreditSurplusAmountValue;
    }

    private double getRealCurrentMonthWithdrawalSurplusAmount(double currentMonthWithdrawalSurplusAmountValue) {
        return currentMonthWithdrawalSurplusAmountValue > maxWithdrawalAmount ? maxWithdrawalAmount : currentMonthWithdrawalSurplusAmountValue;
    }

    private double getRealCurrentMonthCreditSurplusAmount(double currentMonthCreditSurplusAmountValue) {
        return currentMonthCreditSurplusAmountValue > maxCreditAmount ? maxCreditAmount : currentMonthCreditSurplusAmountValue;
    }

}
