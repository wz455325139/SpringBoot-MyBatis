package com.thumbup.repository;

import com.thumbup.model.entity.AuthEntity;

public interface AuthRepository {

	AuthEntity selectByweChatIdAndToken(String weChatId, String authToken);
}
