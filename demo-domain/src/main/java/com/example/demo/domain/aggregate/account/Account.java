package com.example.demo.domain.aggregate.account;

import com.example.demo.domain.aggregate.customer.Customer;
import com.example.demo.domain.aggregate.seedwork.BaseEntity;
import com.example.demo.domain.aggregate.seedwork.BaseOperationType;
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

    @ManyToOne
    protected Customer customer;

    @Convert(converter = AccountTypeConverter.class)
    protected AccountType accountType;

    public void consume(double amount) {
        remainingSum -= amount;
        Ledger ledger = new Ledger(0 - amount, AccountOperationType.CONSUME_MONEY);
        this.addLedger(ledger);
    }

    /**
     * 提款
     *
     * @param amount 提款金额
     * @return 提款后余额
     */
    public void drawMoney(double amount) {
        remainingSum -= amount;
        Ledger ledger = new Ledger(0 - amount, AccountOperationType.DRAW_MONEY);
        this.addLedger(ledger);
    }

    /**
     * 存款
     *
     * @param amount 存款金额
     * @return
     */
    public void depositMoney(double amount) {
        remainingSum += amount;
        Ledger ledger = new Ledger(amount, AccountOperationType.DEPOSIT_MONEY);
        this.addLedger(ledger);
    }

    /**
     * 添加流水账
     *
     * @param ledger 流水账
     */
    public void addLedger(Ledger ledger) {
        ledger.setAccount(this);
        ledger.setBaseInfo(getModifier(), BaseOperationType.SAVE);
        ledgers.add(ledger);

    }
}
