package com.smallintro.springboot.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerProductService {

    @Autowired
    ProductClient productClient;

    public List<Product> getAllProducts() {
        return productClient.getAllProducts();
    }

    public Product getProductsById(Long id) {
        return productClient.getProductsById(id);
    }

    public Product createProduct(Product product) {
        return productClient.createProduct(product);
    }

    public Product updateProduct(Product product) {
        return productClient.updateProduct(product);
    }

    public String deleteAllProducts() {
        return productClient.deleteAllProducts();
    }

    public String deleteProductsById(Long id) {
        return productClient.deleteProductsById(id);
    }

}
