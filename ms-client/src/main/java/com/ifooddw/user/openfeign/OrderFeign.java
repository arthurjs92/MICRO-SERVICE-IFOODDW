package com.ifooddw.user.openfeign;

import com.ifooddw.user.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("ms-store")
public interface OrderFeign {

    @PostMapping("/order/store/{id}")
    public Order createOrderWithStore(@RequestBody Order order, @PathVariable String id);

}
