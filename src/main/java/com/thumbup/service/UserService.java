package com.thumbup.service;

import java.util.Optional;

import com.thumbup.model.entity.User;

public interface UserService {

    Optional<User> getUserById(Long id);

    boolean saveUser(User user);

    boolean modifyUserOnPasswordById(User user);

    boolean deleteUserById(Long id);

}
