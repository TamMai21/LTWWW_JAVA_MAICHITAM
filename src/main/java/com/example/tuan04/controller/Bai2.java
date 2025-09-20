package com.example.tuan04.controller;

import com.example.tuan04.model.Product2;
import com.example.tuan04.service.CartServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "bai2Controller", urlPatterns = {"/bai2"})
public class Bai2 extends HttpServlet {
    private CartServiceImpl cartService;

    @Override
    public void init() {
        this.cartService = new CartServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("bai2.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";

        if (action.equals("add")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            int qty = Integer.parseInt(request.getParameter("quantity"));

            Product2 product = new Product2(id, name, price);
            cartService.addToCart(request.getSession(), product, qty);
        } else if (action.equals("remove")) {
            cartService.removeFromCart(request.getSession(), request.getParameter("id"));
        } else if (action.equals("update")) {
            int qty = Integer.parseInt(request.getParameter("quantity"));
            cartService.updateQuantity(request.getSession(), request.getParameter("id"), qty);
        }

        response.sendRedirect("bai2");
    }
}
