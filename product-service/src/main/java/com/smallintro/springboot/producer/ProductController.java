package com.smallintro.springboot.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductsById(Long id) {
        return productService.getProductsById(id);
    }

    @PostMapping("/")
    public Product createProduct(Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/")
    public Product updateProduct(Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/")
    public String deleteAllProducts() {
        return productService.deleteAllProducts();
    }

    @DeleteMapping("/{id}")
    public String deleteProductsById(Long id) {
        return productService.deleteProductsById(id);
    }

}
