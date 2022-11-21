package com.ifooddw.deliveryman.service.Impl;

import com.ifooddw.deliveryman.model.DeliveryMan;

import java.util.List;
import java.util.Optional;

public interface DeliveryManServiceImpl {

    public DeliveryMan createDeliveryMan(DeliveryMan deliveryMan, String id);
    public Optional<DeliveryMan> findDeliveryManById(String id);
    public List<DeliveryMan> findAllDeliveryMans();
    public DeliveryMan updateDeliveryMan(DeliveryMan deliveryMan) throws Exception;
    public void deleteDeliveryMan(String id);

}
