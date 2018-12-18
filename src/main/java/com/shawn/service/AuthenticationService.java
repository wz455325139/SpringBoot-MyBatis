package com.shawn.service;

public interface AuthenticationService {

    boolean confirmToken(String weChatId, String authToken);
}
