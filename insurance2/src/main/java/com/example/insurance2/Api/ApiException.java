package com.example.insurance2.Api;

public class ApiException extends RuntimeException {
    public ApiException(String message){
        super(message);
    }
}
