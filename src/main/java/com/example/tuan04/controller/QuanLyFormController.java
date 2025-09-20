package com.example.tuan04.controller;

import com.example.tuan04.service.DanhSachTinTucQuanLyImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "quanLyFormServlet", urlPatterns = {"/manage"})
public class QuanLyFormController extends HttpServlet {
    private DanhSachTinTucQuanLyImpl tinTucService;

    @Override
    public void init() {
        this.tinTucService = new DanhSachTinTucQuanLyImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";

        if (action.equals("delete")) {
            String maTT = request.getParameter("maTT");
            tinTucService.xoaTinTuc(request.getSession(), maTT);
        }

        request.setAttribute("danhSachTinTuc", tinTucService.getDanhSachTinTuc(request.getSession()));
        RequestDispatcher rd = request.getRequestDispatcher("QuanLyForm.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}