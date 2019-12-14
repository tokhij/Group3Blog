package com.zipcode.group3blog.group3blog.service;

import com.zipcode.group3blog.group3blog.dto.RegisterRequest;
import com.zipcode.group3blog.group3blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public void signup(RegisterRequest registerRequest){
        User newUser = new User();
        newUser.setUsername(registerRequest.getUsername());
        newUser.setPassword(registerRequest.getPassword());
        newUser.setEmail(registerRequest.getEmail());
    }
}
