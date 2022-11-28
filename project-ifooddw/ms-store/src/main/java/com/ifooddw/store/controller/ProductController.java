package com.ifooddw.store.controller;

import com.ifooddw.store.model.Product;
import com.ifooddw.store.service.Impl.ProductImpl;
import com.ifooddw.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController implements ProductImpl {

    @Autowired
    private ProductService productService;

    @Override
    @PostMapping("/store/{idStore}")
    public Product createProduct(@PathVariable String idStore, @RequestBody Product product) {
        return productService.createProduct(idStore, product);
    }

    @Override
    @GetMapping("/{id}")
    public Optional<Product> findProductById(@PathVariable String id) {
        return productService.findProductById(id);
    }

    @Override
    @GetMapping()
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    @Override
    @PutMapping("/update/store/{idStore}")
    public Product updateProduct(@RequestBody Product product, @PathVariable String idStore) {
        return productService.updateProduct(product, idStore);
    }

    @Override
    @DeleteMapping("/{id}/delete/store/{idStore}")
    public void deleteProduct(@PathVariable String id, @PathVariable String idStore) {
        productService.deleteProduct(id, idStore);
    }
}
