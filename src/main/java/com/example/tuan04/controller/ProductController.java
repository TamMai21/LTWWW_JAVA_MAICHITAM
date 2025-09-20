package com.example.tuan04.controller;

import com.example.tuan04.service.ProductDAOImpl;
import com.example.tuan04.service.interf.ProductDAO;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "productController", urlPatterns = "/products")
public class ProductController extends HttpServlet {
    @Resource(name = "jdbc/shopping")
    private DataSource dataSource;
    private ProductDAO productDAO;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.productDAO = new ProductDAOImpl(this.dataSource);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        req.setAttribute("products", productDAO.findAll2());
        req.getRequestDispatcher("views/product/index.jsp").forward(req, resp);
    }
}
