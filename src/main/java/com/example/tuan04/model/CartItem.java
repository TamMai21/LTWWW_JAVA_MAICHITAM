package com.example.tuan04.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CartItem {
    private Product2 product;
    private int quantity;
    public double getTotal() {
        return product.getPrice() * quantity;
    }
}
