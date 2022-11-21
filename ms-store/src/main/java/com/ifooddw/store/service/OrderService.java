package com.ifooddw.store.service;

import com.ifooddw.store.message.StoreSendMessage;
import com.ifooddw.store.model.*;
import com.ifooddw.store.repository.OrderRepository;
import com.ifooddw.store.repository.StoreRepository;
import com.ifooddw.store.service.Impl.OrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements OrderImpl {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private StoreSendMessage storeSendMessage;

    @Override
    public Optional<Order> findOrderById(String id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> visualizeAllStoreOrders(String id) {
        var store = storeRepository.findById(id).get();
        var orders = store.getOrders();
        return orders;
    }

    public Order createOrder(Order order, String id) {
        var status = Status.NEWORDER;
        order.calcTotalPrice();
        order.setStatus(status.getDescription());
        orderRepository.save(order);
        var reply = storeRepository.findById(id).get();
        if (reply != null) {
            Log<Store> log = new Log<>(reply);
            log.setAction(Action.ADD);
            storeSendMessage.sendMessage(log);
            reply.getOrders().add(order);
            storeRepository.save(reply);
        }
        return order;
    }

    @Override
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order updateOrder(Order order, String id) {
        var objOrder = orderRepository.findById(order.getId()).get();
        var listObjOrders = objOrder.getProducts();
        if (order.getId() != null && !id.isEmpty()) {
            int i = 0;
            for (Product product : objOrder.getProducts()) {
                if(product.getId()!=order.getProducts().get(i++).getId()){
                    listObjOrders.remove(product);
                }
            }
            order.calcTotalPrice();
            objOrder.setTotalPrice(order.getTotalPrice());
            objOrder.setProducts(listObjOrders);
            orderRepository.save(objOrder);
        }
        return objOrder;
    }

    public Order updateOrderStatusToShipped(Order order, String id) {
        var status = Status.ORDERREADY;
        var store = storeRepository.findById(id).get();
        var storeOrder = orderRepository.findById(order.getId()).get();
        if (store != null && order != null) {
            storeOrder.setStatus(status.getDescription());
            orderRepository.save(storeOrder);
        }
        return storeOrder;
    }

    public Order updateOrderStatusToDelivered(Order order, String id) {
        var status = Status.ORDERDELIVERED;
        var store = storeRepository.findById(id).get();
        var storeOrder = orderRepository.findById(order.getId()).get();
        if (store != null && order != null) {
            storeOrder.setStatus(status.getDescription());
            orderRepository.save(storeOrder);
        }
        return storeOrder;
    }

}
