package com.example.tuan04.service.interf;

import com.example.tuan04.model.CartItem;
import com.example.tuan04.model.Product2;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface CartServiceInterf {
    List<CartItem> getCart(HttpSession session);

    void addToCart(HttpSession session, Product2 product, int quantity);

    void removeFromCart(HttpSession session, String productId);

    void updateQuantity(HttpSession session, String productId, int quantity);

    double getTotal(HttpSession session);
}
