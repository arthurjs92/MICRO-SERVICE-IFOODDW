package com.ifooddw.deliveryman.controller;

import com.ifooddw.deliveryman.service.Impl.DeliveryManServiceImpl;
import com.ifooddw.deliveryman.model.DeliveryMan;
import com.ifooddw.deliveryman.model.Order;
import com.ifooddw.deliveryman.service.DeliveryManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deliveryman")
public class DeliveryManController implements DeliveryManServiceImpl {

    @Autowired
    private DeliveryManService deliveryManService;

    @PostMapping
    public DeliveryMan createDeliveryMan(@RequestBody DeliveryMan deliveryMan, @PathVariable String id) {
        return deliveryManService.createDeliveryMan(deliveryMan, id);
    }

    @GetMapping("/{id}")
    public Optional<DeliveryMan> findDeliveryManById(@PathVariable String id) {
        return deliveryManService.findDeliveryManById(id);
    }

    @GetMapping
    public List<DeliveryMan> findAllDeliveryMans() {
        return deliveryManService.findAllDeliveryMans();
    }

    @PutMapping("/update")
    public DeliveryMan updateDeliveryMan(@RequestBody DeliveryMan deliveryMan) throws Exception {
        return deliveryManService.updateDeliveryMan(deliveryMan);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDeliveryMan(@PathVariable String id) {
        deliveryManService.deleteDeliveryMan(id);
    }

    @PutMapping("/update/order/store/{id}/delivered")
    public Order updateOrderToDelivered(@RequestBody Order order, @PathVariable String id){
        return deliveryManService.updateOrderStatusToDelivered(order, id);
    }

}
