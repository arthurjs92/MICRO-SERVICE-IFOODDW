package com.ifooddw.store.controller;

import com.ifooddw.store.model.Order;
import com.ifooddw.store.service.Impl.OrderImpl;
import com.ifooddw.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController implements OrderImpl {

    @Autowired
    private OrderService orderService;

    @Override
    @GetMapping("/{id}")
    public Optional<Order> findOrderById(@PathVariable String id) {
        return orderService.findOrderById(id);
    }

    @Override
    @GetMapping
    public List<Order> findAllOrders() {
        return orderService.findAllOrders();
    }

    @GetMapping("/store/{id}")
    public List<Order> findAllOrdersFromStore(@PathVariable String id) {
        return orderService.visualizeAllStoreOrders(id);
    }

    @PostMapping("/store/{id}")
    public Order createOrderWithStore(@RequestBody Order order, @PathVariable String id) {
        return orderService.createOrder(order, id);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
    }

    @Override
    @PutMapping("/update/store/{id}")
    public Order updateOrder(@RequestBody Order order, @PathVariable String id) {
        return orderService.updateOrder(order, id);
    }

    @PutMapping("/update/status/store/{id}/shipped")
    public Order updateOrderStatusToShipped(@RequestBody Order order, @PathVariable String id) {
        return orderService.updateOrderStatusToShipped(order, id);
    }

    @PutMapping("/update/status/store/{id}/delivered")
    public Order updateOrderStatusToDelivered(@RequestBody Order order, @PathVariable String id) {
        return orderService.updateOrderStatusToDelivered(order, id);
    }

}
