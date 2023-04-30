package com.smallintro.springboot.seller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/")
    List<Product> getAllProducts();

    @GetMapping("/{id}")
    ResponseEntity<Product> getProductsById(@PathVariable Long id);

    @PostMapping("/create")
    ResponseEntity<Product> createProduct(@RequestBody Product product);

    @PutMapping("/update")
    ResponseEntity<Product> updateProduct(@RequestBody Product product);

    @DeleteMapping("/delete/{id}")
    String deleteProductsById(@PathVariable Long id);
}
