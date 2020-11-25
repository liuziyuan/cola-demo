package com.example.demo.domain.aggregate.account;

public enum AccountType {
    DEBIT_ACCOUNT(1),
    CREDIT_ACCOUNT(2);

    private final int code;

    AccountType(int code) {
        this.code = code;
    }

    public static AccountType fromCode(int code) {
        if (code == 1) {
            return DEBIT_ACCOUNT;
        }
        if (code == 2) {
            return CREDIT_ACCOUNT;
        }
        throw new UnsupportedOperationException(
                "The code " + code + " is not supported!"
        );
    }

    public int getCode() {
        return code;
    }
}

