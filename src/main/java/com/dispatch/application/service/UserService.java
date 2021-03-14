package com.dispatch.application.service;

import com.dispatch.application.model.LoginRequest;
import com.dispatch.application.model.Users;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Users findByUsername(String username);
    Users validLogin(LoginRequest loginRequest);
    public Users findByEmail(String email);
    void save(Users user);

}
