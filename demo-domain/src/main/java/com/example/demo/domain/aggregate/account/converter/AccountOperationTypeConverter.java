package com.example.demo.domain.aggregate.account.converter;

import com.example.demo.domain.aggregate.account.AccountOperationType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class AccountOperationTypeConverter implements AttributeConverter<AccountOperationType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(AccountOperationType value) {
        return value.getCode();
    }

    @Override
    public AccountOperationType convertToEntityAttribute(Integer value) {
        return AccountOperationType.fromCode(value);
    }
}