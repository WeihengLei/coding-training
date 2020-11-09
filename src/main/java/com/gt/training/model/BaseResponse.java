
package com.gt.training.model;


import com.gt.training.error.ErrorCode;

public class BaseResponse<T> {
    private String respCode;
    private String message;
    private T responseBody;

    public BaseResponse() {
    }

    public BaseResponse(String respCode) {
        this(respCode, (String)null);
    }

    public BaseResponse(String respCode, String message) {
        this.respCode = respCode;
        this.message = message;
    }

    public String getRespCode() {
        return this.respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
        if (ErrorCode.NORMAL.equals(respCode)) {
            this.message = "success";
        }

    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResponseBody() {
        return this.responseBody;
    }

    public void setResponseBody(T responseBody) {
        this.responseBody = responseBody;
    }

    public String toString() {
        return "BaseResponse{respCode='" + this.respCode + '\'' + ", message='" + this.message + '\'' + ", responseBody=" + this.responseBody + '}';
    }
}
