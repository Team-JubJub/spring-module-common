package com.zupzup.untact.exception.exception.store.customer;

import com.zupzup.untact.exception.exception.store.StoreRuntimeException;
import org.springframework.http.HttpStatus;

public class StoreNotStarredException extends StoreRuntimeException {

    public StoreNotStarredException(String message) {
        super(message, HttpStatus.PRECONDITION_FAILED);
    }
}
