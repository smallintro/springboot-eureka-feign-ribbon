package com.smallintro.springboot.seller;

import lombok.Data;

@Data
public class Product {

    private long productId;

    private String productName;

    private String productCategory;

    private double price;

}
