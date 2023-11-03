package com.zupzup.untact.exception.store;

import com.zupzup.untact.exception.BaseException;
import com.zupzup.untact.exception.BaseExceptionType;

public class StoreException extends BaseException {

    private BaseExceptionType exType;

    public StoreException(BaseExceptionType exType) {
        this.exType = exType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return exType;
    }
}
