package com.thumbup.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thumbup.model.entity.User;
import com.thumbup.repository.UserRepository;
import com.thumbup.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(userRepository.selectUserById(id));
    }

    @Override
    public boolean saveUser(User user) {
        return userRepository.insertUser(user) > 0;
    }

    @Override
    public boolean modifyUserOnPasswordById(User user) {
        return userRepository.updateUserOnPasswordById(user) > 0;
    }

    @Override
    public boolean deleteUserById(Long id) {
        return userRepository.deleteUserById(id) > 0;
    }

}
