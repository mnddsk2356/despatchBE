package com.dispatch.application.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LoginRequest {

    private String username;

    public String getLoginAs() {
        return loginAs;
    }

    public void setLoginAs(String loginAs) {
        this.loginAs = loginAs;
    }

    private String password;

    private String loginAs;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
