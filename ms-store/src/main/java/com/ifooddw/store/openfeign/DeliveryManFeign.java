package com.ifooddw.store.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ms-delivery-man")
public interface DeliveryManFeign {

    @DeleteMapping("/deliveryman/delete/{id}")
    void deleteDeliveryMan(@PathVariable String id);

}
