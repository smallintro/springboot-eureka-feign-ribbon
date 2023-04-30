package com.smallintro.springboot.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class SellerProductController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public List getAllProducts() {
        return restTemplate.getForObject("http://product-service", List.class);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductsById(@PathVariable Long id) {
        return restTemplate.getForEntity("http://product-service/" + id, Product.class);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        System.out.println("create" + product);
        HttpEntity<Product> request = new HttpEntity<>(product);
        return restTemplate.postForEntity("http://product-service/create", request, Product.class);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        HttpEntity<Product> request = new HttpEntity<>(product);
        restTemplate.put("http://product-service/update", request);
        return getProductsById(product.getProductId());
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProductsById(@PathVariable Long id) {
        restTemplate.delete("http://product-service/delete/" + id);
        return "SUCCESS";
    }

}
