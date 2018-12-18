package com.shawn.repository;

import com.shawn.model.entity.AuthEntity;

public interface AuthRepository {

	AuthEntity selectByweChatIdAndToken(String weChatId, String authToken);
}
