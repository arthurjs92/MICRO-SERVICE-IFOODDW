package com.ifooddw.deliveryman.openfeign;

import com.ifooddw.deliveryman.model.Order;
import com.ifooddw.deliveryman.model.Store;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient("ms-store")
public interface StoreFeign {

    @GetMapping("/store/{id}")
    public Optional<Store> findStoreById(@PathVariable String id);

    @PutMapping("/order/update/status/store/{id}/shipped")
    public Order updateOrderStatusToShipped(@RequestBody Order order, @PathVariable String id);

    @PutMapping("/order/update/status/store/{id}/delivered")
    public Order updateOrderStatusToDelivered(@RequestBody Order order, @PathVariable String id);

}
