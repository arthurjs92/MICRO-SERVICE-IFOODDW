package com.ifooddw.store.service.Impl;

import com.ifooddw.store.model.Store;

import java.util.List;
import java.util.Optional;

public interface StoreImpl {

    public Store createStore(Store store);
    public Optional<Store> findStoreById(String id);

    public List<Store> findAllStores();
    public Store updateStore(Store store) throws Exception;
    public void deleteStore(String id) throws Exception;

}
