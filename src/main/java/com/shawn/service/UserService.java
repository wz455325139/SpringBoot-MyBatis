package com.shawn.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.shawn.model.entity.User;

public interface UserService extends UserDetailsService {

    Optional<User> getUserById(Long id);

    boolean saveUser(User user);

    boolean modifyUserOnPasswordById(User user);

    boolean deleteUserById(Long id);

}
