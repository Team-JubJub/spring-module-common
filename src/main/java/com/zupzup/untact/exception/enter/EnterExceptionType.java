package com.zupzup.untact.exception.enter;

import com.zupzup.untact.exception.BaseExceptionType;
import org.springframework.http.HttpStatus;

public enum EnterExceptionType implements BaseExceptionType {

    NO_MATCH_ENTER(HttpStatus.BAD_REQUEST, "해당 id 값을 가진 신청서는 존재하지 않습니다."),
    ENTER_STATE_IS_NOT_NEW(HttpStatus.BAD_REQUEST, "신규 신청 매장이 아닙니다."),
    ENTER_STATE_IS_NOT_WAIT(HttpStatus.BAD_REQUEST, "노출 대기 매장이 아닙니다."),
    ENTER_STATE_IS_NOT_CONFIRM(HttpStatus.BAD_REQUEST, "노출 승인 매장이 아닙니다."),
    IS_ACCEPTED_FALSE(HttpStatus.BAD_REQUEST, "아직 승인되지 않은 가게입니다."),
    SEVER_ERR(HttpStatus.EXPECTATION_FAILED, "서버 통신에 실패하였습니다. 다시 시도해주세요.");

//    private int errorCode;
    private HttpStatus httpStatus;
    private String errorMessage;

    EnterExceptionType(HttpStatus httpStatus, String errorMessage) {
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
