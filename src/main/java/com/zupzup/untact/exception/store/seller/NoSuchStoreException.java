package com.zupzup.untact.exception.store.seller;

import com.zupzup.untact.exception.store.StoreRuntimeException;
import org.springframework.http.HttpStatus;

public class NoSuchStoreException extends StoreRuntimeException {

    public NoSuchStoreException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

}
