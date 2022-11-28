package com.ifooddw.store.service.Impl;

import com.ifooddw.store.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductImpl {

    public Product createProduct(String idStore, Product product);
    public Optional<Product> findProductById(String id);

    public List<Product> findAllProducts();
    public Product updateProduct(Product product, String idStore);
    public void deleteProduct(String id, String idStore);

}
