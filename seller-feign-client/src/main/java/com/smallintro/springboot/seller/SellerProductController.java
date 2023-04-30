package com.smallintro.springboot.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SellerProductController {

    @Autowired
    ProductClient productClient;

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productClient.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductsById(@PathVariable Long id) {
        return productClient.getProductsById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return productClient.createProduct(product);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return productClient.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProductsById(@PathVariable Long id) {
        return productClient.deleteProductsById(id);
    }

}
