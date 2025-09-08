package com.example.tuan03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private String id;
    private String model;
    private String description;
    private int quantity;
    private double price;
    private String imgURL;
}
