package com.zupzup.untact.exception.store;

import com.zupzup.untact.exception.BaseExceptionType;
import org.springframework.http.HttpStatus;

public enum StoreExceptionType implements BaseExceptionType {

    NO_MATCH_STORE(HttpStatus.BAD_REQUEST, "Store with provided unique ID doesn't present."),
    CANNOT_APPLY_TWICE(HttpStatus.BAD_REQUEST, "가게 입점 신청은 한 번만 가능합니다."),
    SEVER_ERR(HttpStatus.EXPECTATION_FAILED, "서버 통신에 실패하였습니다. 다시 시도해주세요.");

//    private int errorCode;
    private HttpStatus httpStatus;
    private String errorMessage;

    StoreExceptionType(HttpStatus httpStatus, String errorMessage) {
//        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

//    @Override
//    public int getErrCode() {
//        return this.errorCode;
//    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    @Override
    public String getErrMsg() {
        return this.errorMessage;
    }
}
