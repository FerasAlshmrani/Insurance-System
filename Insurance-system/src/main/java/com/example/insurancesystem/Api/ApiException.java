package com.example.insurancesystem.Api;

public class ApiException extends RuntimeException {
    public ApiException(String message){
        super(message);
    }
}
