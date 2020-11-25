package com.example.demo.domain.aggregate.account;

public enum AccountOperationType {
    DEPOSIT_MONEY(1),
    DRAW_MONEY(2),
    CONSUME_MONEY(3);



    private final int code;

    AccountOperationType(int code){
        this.code = code;
    }

    public static AccountOperationType fromCode(int code) {
        if (code == 1) {
            return DEPOSIT_MONEY;
        }
        if (code == 2) {
            return DRAW_MONEY;
        }
        if (code == 3) {
            return CONSUME_MONEY;
        }
        throw new UnsupportedOperationException(
                "The code " + code + " is not supported!"
        );
    }

    public int getCode() {
        return code;
    }
}
