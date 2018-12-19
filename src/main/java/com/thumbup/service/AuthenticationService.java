package com.thumbup.service;

public interface AuthenticationService {

    boolean confirmToken(String weChatId, String authToken);
}
