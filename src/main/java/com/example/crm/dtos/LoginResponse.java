package com.example.crm.dtos;

public class LoginResponse {

    private String token;

    public LoginResponse() {
    }

    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getTokenValue() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}