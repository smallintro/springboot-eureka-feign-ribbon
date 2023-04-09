package com.smallintro.springboot.producer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table
@Data
@Entity
public class Product {

    @Id
    private long productId;

    private String productName;

}
