package com.smallintro.springboot.producer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    private long productId;

    private String productName;

    private String productCategory;

    private double price;


}
