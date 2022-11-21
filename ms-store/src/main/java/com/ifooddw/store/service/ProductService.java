package com.ifooddw.store.service;

import com.ifooddw.store.message.StoreSendMessage;
import com.ifooddw.store.model.Action;
import com.ifooddw.store.model.Log;
import com.ifooddw.store.model.Product;
import com.ifooddw.store.model.Store;
import com.ifooddw.store.repository.ProductRepository;
import com.ifooddw.store.repository.StoreRepository;
import com.ifooddw.store.service.Impl.ProductImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductImpl {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StoreSendMessage storeSendMessage;

    @Override
    public Product createProduct(String idStore, Product product) {
        var reply = productRepository.save(product);

        if (reply != null) {
            var store = storeRepository.findById(idStore).get();
            store.getProducts().add(reply);
            Log<Store> log = new Log<>(store);
            log.setAction(Action.ADD);
            storeSendMessage.sendMessage(log);
            storeRepository.save(store);
        }
        return reply;
    }

    @Override
    public Optional<Product> findProductById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product, String idStore) {
        if (product.getId() != null && !product.getId().isEmpty()) {
            var reply = storeRepository.findById(idStore).get();
            Log<Store> log = new Log<>(reply);
            log.setAction(Action.UPDATE);
            storeSendMessage.sendMessage(log);
            productRepository.save(product);
        }
        return product;
    }

    @Override
    public void deleteProduct(String id, String idStore) {
        if (id!=null && !id.isEmpty()){
            var reply = storeRepository.findById(idStore).get();
            Log<Store> log = new Log<>(reply);
            log.setAction(Action.REMOVE);
            storeSendMessage.sendMessage(log);
            productRepository.deleteById(id);
        }

    }
}
