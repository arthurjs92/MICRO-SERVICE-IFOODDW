package com.ifooddw.user.service;

import com.ifooddw.user.model.Order;
import com.ifooddw.user.model.User;
import com.ifooddw.user.openfeign.OrderFeign;
import com.ifooddw.user.repository.UserRepository;
import com.ifooddw.user.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderFeign orderFeign;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, String id) {
        if(!id.isEmpty() && id != null){
           return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public User userCreateOrder(String idUser, String idStore, Order order){
        var user = userRepository.findById(idUser).get();
        if (user.getId()!=null && !user.getId().isEmpty()){
            var userOrder = orderFeign.createOrderWithStore(order, idStore);
            user.getOrders().add(userOrder);
        }
        return user;
    }

    public List<Order> findAllUsersOrders(User user){
        List<Order> orders = user.getOrders();
        if(user.getId()!=null && !user.getId().isEmpty()){
            return orders;
        }
        return null;
    }

}
