package com.zupzup.untact.exception.auth.customer;

import com.zupzup.untact.exception.auth.AuthRuntimeException;
import com.zupzup.untact.model.enums.auth.Provider;
import org.springframework.http.HttpStatus;

public class AlreadySignUppedException extends AuthRuntimeException {

    private Provider provider;
    private static final String MESSAGE = "User already sign-upped. ";

    public AlreadySignUppedException(Provider provider) {
        super(MESSAGE + "(Platform with: " + provider.getProvider() + ")", HttpStatus.CONFLICT);
        this.provider = provider;
    }

}
