package com.ifooddw.store.service.Impl;

import com.ifooddw.store.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderImpl {

//    public Order createOrder(Order order);
    public Optional<Order> findOrderById(String id);

    public List<Order> findAllOrders();
    public Order updateOrder(Order order, String id) throws Exception;
    public void deleteOrder(String id);

}
