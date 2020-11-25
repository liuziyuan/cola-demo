package com.example.demo.domain.aggregate.account.entity;

import com.example.demo.domain.aggregate.account.entity.Account;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class DebitAccount extends Account {


}
