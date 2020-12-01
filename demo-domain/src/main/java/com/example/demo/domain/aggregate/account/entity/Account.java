package com.example.demo.domain.aggregate.account.entity;

import com.example.demo.domain.aggregate.account.AccountOperationType;
import com.example.demo.domain.aggregate.account.AccountType;
import com.example.demo.domain.aggregate.account.converter.AccountTypeConverter;
import com.example.demo.domain.aggregate.customer.entity.Customer;
import com.example.demo.domain.seedwork.BaseEntity;
import com.example.demo.domain.seedwork.BaseOperationType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Account extends BaseEntity {

    protected String accountNo;

    protected double remainingSum;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected List<Ledger> ledgers;

    // 聚合根应该禁止对其他聚合根的直接关联引用,聚合之间应该是弱耦合的
    // 聚合之间通过聚合根的唯一ID来关联,而不是直接对象引用的方式,外部的聚合对象如果在本聚合范围内管理,容易导致边界不清晰,增加聚合之间的耦合度
    // Account与Customer的关联关系,建议直接以customerId的方式表达,此处为OOD对象关联关系的常规的表达方式,非遵循DDD Aggregate Root的设计原则
    @ManyToOne
    protected Customer customer;

    @Convert(converter = AccountTypeConverter.class)
    protected AccountType accountType;

    /**
     * 计算账号余额
     * @param amount 金额
     * @param type 操作类型
     */
    public double calculateRemainingSum(double remainingSumValue, double amount, AccountOperationType type){
        switch (type){
            case DEPOSIT_MONEY:
                remainingSumValue += amount;
                break;
            case DRAW_MONEY:
                remainingSumValue -= amount;
                break;
            case CONSUME_MONEY:
                remainingSumValue -= amount;
                break;
        }
        return remainingSumValue;
    }

    /**
     * 消费
     * @param amount 消费金额
     */
    public void consume(double amount) {
        remainingSum = calculateRemainingSum(remainingSum, amount, AccountOperationType.CONSUME_MONEY);
        Ledger ledger = new Ledger(0 - amount, AccountOperationType.CONSUME_MONEY);
        addLedger(ledger);
    }

    /**
     * 提款
     * @param amount 提款金额
     */
    public void drawMoney(double amount) {
        remainingSum = calculateRemainingSum(remainingSum, amount, AccountOperationType.DRAW_MONEY);
        Ledger ledger = new Ledger(0 - amount, AccountOperationType.DRAW_MONEY);
        addLedger(ledger);
    }

    /**
     * 存款
     * @param amount 存款金额
     */
    public void depositMoney(double amount) {
        remainingSum = calculateRemainingSum(remainingSum, amount, AccountOperationType.DEPOSIT_MONEY);
        Ledger ledger = new Ledger(amount, AccountOperationType.DEPOSIT_MONEY);
        addLedger(ledger);
    }

    /**
     * 添加流水账
     * @param ledger 流水账
     */
    public void addLedger(Ledger ledger) {
        ledger.setAccount(this);
        ledger.setBaseInfo(getModifier(), BaseOperationType.SAVE);
        ledgers.add(ledger);

    }
}
