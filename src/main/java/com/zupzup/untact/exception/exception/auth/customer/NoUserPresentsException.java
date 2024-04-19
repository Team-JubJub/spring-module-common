package com.zupzup.untact.exception.exception.auth.customer;

import com.zupzup.untact.exception.exception.auth.AuthRuntimeException;
import org.springframework.http.HttpStatus;


public class NoUserPresentsException extends AuthRuntimeException {

    private static final String MESSAGE = "User with provided unique ID doesn't present";

    public NoUserPresentsException() {
        super(MESSAGE, HttpStatus.UNAUTHORIZED);
    }

}
