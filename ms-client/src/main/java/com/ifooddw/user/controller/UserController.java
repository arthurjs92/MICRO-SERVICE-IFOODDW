package com.ifooddw.user.controller;

import com.ifooddw.user.model.Order;
import com.ifooddw.user.model.User;
import com.ifooddw.user.service.UserServiceImpl;
import com.ifooddw.user.service.impl.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController implements UserService {

    public UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    @PostMapping
    public User createUser(User user) {
        return userServiceImpl.createUser(user);
    }

    @Override
    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable String id) {
        return userServiceImpl.findUserById(id);
    }

    @Override
    @GetMapping
    public List<User> findAllUsers() {
        return userServiceImpl.findAllUsers();
    }

    @Override
    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody User user, @PathVariable String id) {
        return userServiceImpl.updateUser(user, id);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable String id) {
        userServiceImpl.deleteUser(id);
    }

    @PostMapping("/{idUser}/store{idStore}/order")
    public User clientCreateOrder(@PathVariable String idUser, @PathVariable String idStore, @RequestBody Order order){
        return userServiceImpl.userCreateOrder(idUser, idStore, order);
    }

    @GetMapping("/{id}/orders")
    public List<Order> findAllUsersOrders(@RequestBody User user){
        return userServiceImpl.findAllUsersOrders(user);
    }
}
