package com.zupzup.untact.exception.store.order;

import org.springframework.http.HttpStatus;

public class NoSuchOrderException extends OrderRuntimeException{

    private static final String MESSAGE = "해당 ID에 해당하는 주문이 존재하지 않습니다.";

    public NoSuchOrderException() {
        super(MESSAGE, HttpStatus.NOT_FOUND);
    }

}
