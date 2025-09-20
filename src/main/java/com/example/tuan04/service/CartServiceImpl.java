package com.example.tuan04.service;

import com.example.tuan04.model.CartItem;
import com.example.tuan04.model.Product2;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements com.example.tuan04.service.interf.CartServiceInterf {


    @Override
    public List<CartItem> getCart(HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    @Override
    public void addToCart(HttpSession session, Product2 product, int quantity) {
        List<CartItem> cart = getCart(session);
        for (CartItem item : cart) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cart.add(new CartItem(product, quantity));
    }

    @Override
    public void removeFromCart(HttpSession session, String productId) {
        List<CartItem> cart = getCart(session);
        cart.removeIf(item -> item.getProduct().getId().equals(productId));
    }

    @Override
    public void updateQuantity(HttpSession session, String productId, int quantity) {
        List<CartItem> cart = getCart(session);
        for (CartItem item : cart) {
            if (item.getProduct().getId().equals(productId)) {
                item.setQuantity(quantity);
                return;
            }
        }
    }

    @Override
    public double getTotal(HttpSession session) {
        List<CartItem> cart = getCart(session);
        return cart.stream().mapToDouble(CartItem::getTotal).sum();
    }
}
