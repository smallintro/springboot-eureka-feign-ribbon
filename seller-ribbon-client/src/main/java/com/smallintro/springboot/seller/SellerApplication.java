package com.smallintro.springboot.seller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


@SpringBootApplication
@RibbonClient(name = "product-service", configuration = RibbonConfig.class)
public class SellerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellerApplication.class, args);
    }
}
