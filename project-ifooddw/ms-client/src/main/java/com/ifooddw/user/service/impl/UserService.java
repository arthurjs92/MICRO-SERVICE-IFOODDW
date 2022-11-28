package com.ifooddw.user.service.impl;

import com.ifooddw.user.dto.UserDTO;
import com.ifooddw.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User createUser(User user);
    public Optional<UserDTO> findUserById(String id);
    public List<UserDTO> findAllUsers();
    public User updateUser(User user, String id);
    public void deleteUser(String id);

}
