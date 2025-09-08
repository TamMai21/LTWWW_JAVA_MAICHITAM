package com.example.tuan03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartItemBean {
    private String partNumber;
    private String modelDescription;
    private double unitCost;
    private int quantity;
    private double totalCost;
}

