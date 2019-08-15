package com.dthealth.dao.entity;

import org.springframework.http.HttpStatus;

public class ResultResponse {
    private HttpStatus statusCode;
    private Object object;

    public ResultResponse(HttpStatus statusCode, Object object) {
        this.statusCode = statusCode;
        this.object = object;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public Object getObject() {
        return object;
    }
}
