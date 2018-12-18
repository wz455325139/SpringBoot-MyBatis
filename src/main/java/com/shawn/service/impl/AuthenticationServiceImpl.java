package com.shawn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.shawn.model.entity.AuthEntity;
import com.shawn.repository.AuthRepository;
import com.shawn.service.AuthenticationService;

public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthRepository repository;

    @Override
    public boolean confirmToken(String weChatId, String authToken) {
        AuthEntity auth = repository.selectByweChatIdAndToken(weChatId, authToken);
        if (auth == null) {
            return false;
        }
        return true;
    }

}
