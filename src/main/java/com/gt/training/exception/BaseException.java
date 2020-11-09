package com.gt.training.exception;


/**
 * Created by WeiHang on 2020/02/22.
 */
public class BaseException extends Exception {

    private String errorCode;

    public BaseException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BaseException(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String toString() {
        return "[errorCode=" + this.errorCode + ", detailMessage=" + this.getMessage() + "]";
    }
}