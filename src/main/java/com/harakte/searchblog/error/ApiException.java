package com.harakte.searchblog.error;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException{

    private final ErrorStatus errorStatus;
    private String appendErrorMessage;

    public ApiException(ErrorStatus errorStatus){
        super(errorStatus.getErrorMessage());
        this.errorStatus = errorStatus;
    }

    public ApiException(ErrorStatus errorStatus, String appendErrorMessage){
        super(errorStatus.getErrorMessage());
        this.errorStatus = errorStatus;
        this.appendErrorMessage = appendErrorMessage;
    }

    public ApiException(ErrorStatus errorStatus, Throwable cause) {
        super(cause);
        this.errorStatus = errorStatus;
    }

    public ApiException(ErrorStatus errorStatus, Throwable cause, String appendErrorMessage){
        super(cause);
        this.errorStatus = errorStatus;
        this.appendErrorMessage = appendErrorMessage;
    }
}
