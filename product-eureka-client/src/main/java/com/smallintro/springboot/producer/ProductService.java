package com.smallintro.springboot.producer;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductsById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product createProduct(Product product) {
        if (productRepository.findById(product.getProductId()).isPresent()) {
            // throw new RuntimeException("Product already exists");
            log.warn("Product already exists. It will be updated");
        }
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        productRepository.findById(product.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        return productRepository.save(product);
    }

    public String deleteAllProducts() {
        productRepository.deleteAll();
        return "success";
    }

    public String deleteProductsById(Long id) {
        productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.deleteById(id);
        return "success";
    }

}
