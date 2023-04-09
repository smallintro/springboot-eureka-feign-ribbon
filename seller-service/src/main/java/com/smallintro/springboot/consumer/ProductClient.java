package com.smallintro.springboot.consumer;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;


@FeignClient(name = "productClient", url = "producer-service")
public interface ProductClient {

    @GetMapping("/")
    List<Product> getAllProducts();

    @GetMapping("/{id}")
    Product getProductsById(Long id);

    @PostMapping("/")
    Product createProduct(Product product);

    @PutMapping("/")
    Product updateProduct(Product product);

    @DeleteMapping("/")
    String deleteAllProducts();

    @DeleteMapping("/{id}")
    String deleteProductsById(Long id);

}
