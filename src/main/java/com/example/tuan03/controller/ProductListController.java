package com.example.tuan03.controller;

import com.example.tuan03.model.Product;
import com.example.tuan03.model.ProductList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet(name = "productListController", urlPatterns = {"/bai4/modelList"})
public class ProductListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Product> list = ProductList.queryProducts();
        request.setAttribute("ds", list);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ModelList.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}