package com.ifooddw.user.openfeign;

import com.ifooddw.user.dto.OrderDTO;
import com.ifooddw.user.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("ms-store")
public interface OrderFeign {

    @PostMapping("/order/store/")
    public Order createOrderWithStore(@RequestBody OrderDTO orderDTO);

}
