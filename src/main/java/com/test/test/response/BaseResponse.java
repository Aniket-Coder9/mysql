package com.test.test.response;

import java.io.Serializable;

public abstract class BaseResponse implements Serializable {
    private static final long serialVersionUID = 6569462459989980292L;

    private String message;

    private String errorCode;

    private boolean success;

    private Long serverTime = System.currentTimeMillis() / 1000;

    public BaseResponse() {
        this.success = true;
        // this.message = Constants.OK;
        this.message = "OK";
    }

    public BaseResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public BaseResponse(boolean success, String errorCode, String message) {
        this.success = success;
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Long getServerTime() {
        return serverTime;
    }

    public void setServerTime(Long serverTime) {
        this.serverTime = serverTime;
    }
}
