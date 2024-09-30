package com.test.test.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> extends BaseResponse {

    private T data;

    public Response(T data) {
        super();
        this.data = data;
    }

    public Response() {
        super();
    }

    public Response(boolean success, String message) {
        super(success, message);
    }

    public Response(boolean success, String errorCode, String message, T data) {
        super(success, errorCode, message);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
