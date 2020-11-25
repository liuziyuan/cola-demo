package com.example.demo.dto.clientobject;

import com.alibaba.cola.dto.ClientObject;
import lombok.Data;

@Data
public class AccountCO extends ClientObject {
    private String accountNo;
    private double remainingSum;
    private int accountType;
    protected double maxCreditAmount;
    private double maxWithdrawalAmount;
    private String BillDay;
    private String repaymentDate;

    private Long customerId;
}
