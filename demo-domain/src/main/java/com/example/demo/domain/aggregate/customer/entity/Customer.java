package com.example.demo.domain.aggregate.customer.entity;

import com.example.demo.domain.aggregate.account.entity.Account;
import com.example.demo.domain.aggregate.customer.valueobject.IdentityCard;
import com.example.demo.domain.seedwork.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Customer extends BaseEntity {
    private IdentityCard idInfo;
    private double totalAmount;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Account> accounts;

    public void calculateTotalAmount(){
        for (Account account: accounts) {
            totalAmount += account.getRemainingSum();
        }
    }
}
