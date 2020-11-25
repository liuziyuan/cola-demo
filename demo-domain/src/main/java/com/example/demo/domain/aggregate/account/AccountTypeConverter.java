package com.example.demo.domain.aggregate.account;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class AccountTypeConverter
        implements AttributeConverter<AccountType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(AccountType value) {
        return value.getCode();
    }

    @Override
    public AccountType convertToEntityAttribute(Integer value) {
        return AccountType.fromCode( value );
    }
}

