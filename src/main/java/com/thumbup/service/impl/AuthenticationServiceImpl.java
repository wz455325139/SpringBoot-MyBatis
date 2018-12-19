package com.thumbup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.thumbup.model.entity.AuthEntity;
import com.thumbup.repository.AuthRepository;
import com.thumbup.service.AuthenticationService;

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
