package com.zupzup.untact.exception.exception.auth.seller;

import com.zupzup.untact.exception.exception.auth.AuthRuntimeException;
import org.springframework.http.HttpStatus;

public class WantDeletionSellerException extends AuthRuntimeException {

    private static final String MESSAGE = "This seller is in deletion state";

    public WantDeletionSellerException() { super(MESSAGE, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS); }

}
