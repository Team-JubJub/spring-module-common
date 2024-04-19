package com.zupzup.untact.exception.exception.auth.customer;

import com.zupzup.untact.model.domain.auth.user.Provider;
import com.zupzup.untact.exception.exception.auth.AuthRuntimeException;
import org.springframework.http.HttpStatus;

public class AlreadySignUppedException extends AuthRuntimeException {

    private Provider provider;
    private static final String MESSAGE = "User already sign-upped. ";

    public AlreadySignUppedException(Provider provider) {
        super(MESSAGE + "(Platform with: " + provider.getProvider() + ")", HttpStatus.CONFLICT);
        this.provider = provider;
    }

}
