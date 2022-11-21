package com.ifooddw.user.service.impl;

import com.ifooddw.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User createUser(User user);
    public Optional<User> findUserById(String id);
    public List<User> findAllUsers();
    public User updateUser(User user, String id);
    public void deleteUser(String id);

}
