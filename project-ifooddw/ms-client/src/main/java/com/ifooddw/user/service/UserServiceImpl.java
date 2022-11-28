package com.ifooddw.user.service;

import com.ifooddw.user.dto.OrderDTO;
import com.ifooddw.user.dto.UserDTO;
import com.ifooddw.user.model.Order;
import com.ifooddw.user.model.User;
import com.ifooddw.user.openfeign.OrderFeign;
import com.ifooddw.user.repository.UserRepository;
import com.ifooddw.user.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Optional<UserDTO> findUserById(String id) {
        var user = userRepository.findById(id).get();
        UserDTO userDTO = new UserDTO(user.getName(), user.getCpf(), user.getAddress());
        return Optional.of(userDTO);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        var userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            userDTOList.add(new UserDTO(user.getName(),user.getCpf(), user.getAddress()));
        }
        return userDTOList;
    }

    @Override
    public User updateUser(User user, String id) {
        if (!id.isEmpty() && id != null) {
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public User userCreateOrder(String id, String idStore, Order order) {
        if (id != null && !id.isEmpty()) {
            if (idStore != null && !idStore.isEmpty()) {
                var userOrder = orderFeign.createOrderWithStore(new OrderDTO(idStore, order.getProducts()));
                addOrderToUser(id, userOrder);
            }
        }
        return userRepository.findById(id).get();
    }

    public User addOrderToUser(String id, Order order) {
        var user = userRepository.findById(id).get();
        user.getOrders().add(order);
        userRepository.save(user);
        return user;
    }

    public List<Order> findAllUsersOrders(User user) {
        List<Order> orders = user.getOrders();
        if (user.getId() != null && !user.getId().isEmpty()) {
            return orders;
        }
        return null;
    }

}
