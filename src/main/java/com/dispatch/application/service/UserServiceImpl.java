package com.dispatch.application.service;

import com.dispatch.application.entities.UserPersonalDetails;
import com.dispatch.application.model.LoginRequest;
import com.dispatch.application.model.Users;
import com.dispatch.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Users validLogin(LoginRequest loginRequest) {
        return userRepository.validLogin(loginRequest);
    }



    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void save(Users user) {
        userRepository.save(user);
    }

}
