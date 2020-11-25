package com.example.demo.domain.aggregate.account.entity;

import com.example.demo.domain.aggregate.account.AccountOperationType;
import com.example.demo.domain.aggregate.account.converter.AccountOperationTypeConverter;
import com.example.demo.domain.seedwork.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Ledger extends BaseEntity {
    public Ledger() {

    }
    public Ledger(double amount, AccountOperationType accountOperationType){
        this.amount = amount;
        this.accountOperationType = accountOperationType;
    }

    @ManyToOne
    private Account account;

    private double amount;

    @Convert(converter = AccountOperationTypeConverter.class)
    private AccountOperationType accountOperationType;



}
