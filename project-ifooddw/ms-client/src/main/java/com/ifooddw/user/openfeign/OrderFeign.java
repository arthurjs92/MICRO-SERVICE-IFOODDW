package com.ifooddw.user.openfeign;

import com.ifooddw.user.dto.OrderDTO;
import com.ifooddw.user.model.Order;
import com.ifooddw.user.model.Store;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient("ms-store")
public interface OrderFeign {

    @PostMapping("/order/store/")
    public Order createOrderWithStore(@RequestBody OrderDTO orderDTO);

    @GetMapping("/store/{id}")
    public Optional<Store> findStoreById(@PathVariable String id);

}
