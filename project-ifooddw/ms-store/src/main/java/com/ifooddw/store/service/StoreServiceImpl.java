package com.ifooddw.store.service;

import com.ifooddw.store.message.StoreSendMessage;
import com.ifooddw.store.model.*;
import com.ifooddw.store.openfeign.DeliveryManFeign;
import com.ifooddw.store.repository.OrderRepository;
import com.ifooddw.store.repository.ProductRepository;
import com.ifooddw.store.repository.StoreRepository;
import com.ifooddw.store.service.Impl.StoreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreImpl {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DeliveryManFeign deliveryManFeign;

    @Autowired
    private StoreSendMessage storeSendMessage;

    @Override
    public Store createStore(Store store) {
        var reply = storeRepository.save(store);
        Log<Store> log = new Log<>(reply);
        log.setAction(Action.ADD);
        storeSendMessage.sendMessage(log);
        return reply;
    }

    @Override
    public Optional<Store> findStoreById(String id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Store updateStore(Store store) {
        if (store.getId() != null && !store.getId().isEmpty()) {
            Log<Store> log = new Log<>(store);
            log.setAction(Action.UPDATE);
            storeSendMessage.sendMessage(log);
            storeRepository.save(store);
        }
        return store;
    }

    @Override
    public void deleteStore(String id) throws Exception {
        var store = storeRepository.findById(id).get();
        var orders = store.getOrders();
        var products = store.getProducts();
        if (id != null && !id.isEmpty()) {
            Log<Store> log = new Log<>(store);
            log.setAction(Action.REMOVE);
            storeSendMessage.sendMessage(log);
            for (Order order : orders) {
                orderRepository.deleteById(order.getId());
            }
            for (Product product : products) {
                productRepository.deleteById(product.getId());
            }
            if (store.getDeliveryMan() == null) {
                storeRepository.deleteById(id);
            } else {
                deliveryManFeign.deleteDeliveryMan(store.getDeliveryMan().getId());
                storeRepository.deleteById(id);
            }
        }
    }
}
