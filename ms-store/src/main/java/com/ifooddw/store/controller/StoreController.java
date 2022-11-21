package com.ifooddw.store.controller;

import com.ifooddw.store.model.Store;
import com.ifooddw.store.service.Impl.StoreImpl;
import com.ifooddw.store.service.OrderService;
import com.ifooddw.store.service.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/store")
public class StoreController implements StoreImpl {

    @Autowired
    private OrderService orderService;

    @Autowired
    private StoreServiceImpl storeService;

    @Override
    @PostMapping
    public Store createStore(@RequestBody Store store) {
        return storeService.createStore(store);
    }

    @Override
    @GetMapping("/{id}")
    public Optional<Store> findStoreById(@PathVariable String id) {
        return storeService.findStoreById(id);
    }

    @Override
    @GetMapping
    public List<Store> findAllStores() {
        return storeService.findAllStores();
    }

    @Override
    @PutMapping("/update")
    public Store updateStore(@RequestBody Store store) throws Exception {
        return storeService.updateStore(store);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteStore(@PathVariable String id) throws Exception{
        storeService.deleteStore(id);
    }

}
