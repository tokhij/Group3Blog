package com.zipcode.group3blog.service;

import com.zipcode.group3blog.dto.LoginRequest;
import com.zipcode.group3blog.dto.RegisterRequest;
import com.zipcode.group3blog.model.User;
import com.zipcode.group3blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;



    public void signup(RegisterRequest registerRequest){
        User newUser = new User();
        newUser.setUsername(registerRequest.getUsername());
        newUser.setPassword(registerRequest.getPassword());
        newUser.setEmail(registerRequest.getEmail());
    }

    public void login(LoginRequest loginRequest){}
}
