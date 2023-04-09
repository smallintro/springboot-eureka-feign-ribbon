package com.smallintro.springboot.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SellerProductController {

    @Autowired
    SellerProductService sellerProductService;

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return sellerProductService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductsById(Long id) {
        return sellerProductService.getProductsById(id);
    }

    @PostMapping("/")
    public Product createProduct(Product product) {
        return sellerProductService.createProduct(product);
    }

    @PutMapping("/")
    public Product updateProduct(Product product) {
        return sellerProductService.updateProduct(product);
    }

    @DeleteMapping("/")
    public String deleteAllProducts() {
        return sellerProductService.deleteAllProducts();
    }

    @DeleteMapping("/{id}")
    public String deleteProductsById(Long id) {
        return sellerProductService.deleteProductsById(id);
    }

}
