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

    // 聚合根应该禁止对其他聚合根的直接关联引用,聚合之间应该是弱耦合的.不提倡Customer与Account List产生关联
    // 聚合之间通过聚合根的唯一ID来关联,而不是直接对象引用的方式,外部的聚合对象如果在本聚合范围内管理,容易导致边界不清晰,增加聚合之间的耦合度
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Account> accounts;

    public void calculateTotalAmount(){
        for (Account account: accounts) {
            totalAmount += account.getRemainingSum();
        }
    }
}
