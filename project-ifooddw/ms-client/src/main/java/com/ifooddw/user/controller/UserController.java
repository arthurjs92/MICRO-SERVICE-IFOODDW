package com.ifooddw.user.controller;

import com.ifooddw.user.dto.UserDTO;
import com.ifooddw.user.model.Order;
import com.ifooddw.user.model.Product;
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
    public User createUser(@RequestBody User user) {
        return userServiceImpl.createUser(user);
    }

    @Override
    @GetMapping("/{id}")
    public Optional<UserDTO> findUserById(@PathVariable String id) {
        return userServiceImpl.findUserById(id);
    }

    @Override
    @GetMapping
    public List<UserDTO> findAllUsers() {
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

    @PostMapping("/{id}/store/{idStore}/order")
    public User clientCreateOrder(@PathVariable String id, @PathVariable String idStore, @RequestBody Order order){
        return userServiceImpl.userCreateOrder(id, idStore,order);
    }

    @GetMapping("/{id}/orders")
    public List<Order> findAllUsersOrders(@RequestBody User user){
        return userServiceImpl.findAllUsersOrders(user);
    }

    @GetMapping("/visualize/products/store/{id}")
    public List<Product> visualizeProductsFromSelectedStore(@PathVariable String id){
        return userServiceImpl.findProductsFromStore(id);
    }
}
