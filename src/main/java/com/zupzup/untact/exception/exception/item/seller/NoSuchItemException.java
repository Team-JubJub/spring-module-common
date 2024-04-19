package com.zupzup.untact.exception.exception.item.seller;

import com.zupzup.untact.exception.exception.item.ItemRuntimeException;
import org.springframework.http.HttpStatus;

public class NoSuchItemException extends ItemRuntimeException {

    public NoSuchItemException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

}
