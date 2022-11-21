package com.ifooddw.deliveryman.service;


import com.ifooddw.deliveryman.service.Impl.DeliveryManServiceImpl;
import com.ifooddw.deliveryman.model.DeliveryMan;
import com.ifooddw.deliveryman.model.Order;
import com.ifooddw.deliveryman.openfeign.StoreFeign;
import com.ifooddw.deliveryman.repository.DeliveryManRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DeliveryManService implements DeliveryManServiceImpl {

    @Autowired
    private StoreFeign storeFeign;

    @Autowired
    private DeliveryManRepository deliveryManRepository;

    @Override
    public DeliveryMan createDeliveryMan(DeliveryMan deliveryMan, String id) {
        var verifyDeliveryMan = deliveryManRepository.findByCpf(deliveryMan.getCpf());
        if (verifyDeliveryMan == null && deliveryMan.getStore() != null) {
            deliveryMan.setStore(storeFeign.findStoreById(id).get());
            deliveryManRepository.save(deliveryMan);
        }
        return null;
    }

    @Override
    public Optional<DeliveryMan> findDeliveryManById(String id) {
        return deliveryManRepository.findById(id);
    }

    @Override
    public List<DeliveryMan> findAllDeliveryMans() {
        return deliveryManRepository.findAll();
    }

    @Override
    public DeliveryMan updateDeliveryMan(DeliveryMan deliveryMan) throws Exception {
        var deliveryManUpdated = deliveryManRepository.findById(deliveryMan.getId()).get();
        if (deliveryMan.getId() != null && deliveryMan.getStore() == deliveryManUpdated.getStore()) {
            return deliveryManRepository.save(deliveryMan);
        } else {
            throw new Exception();
        }
    }

    @Override
    public void deleteDeliveryMan(String id) {
        deliveryManRepository.deleteById(id);
    }

    public Order updateOrderStatusToDelivered(Order order, String id) {
        return storeFeign.updateOrderStatusToDelivered(order, id);
    }

}
