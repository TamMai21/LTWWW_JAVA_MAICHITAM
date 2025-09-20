package com.example.tuan04.controller;

import com.example.tuan04.model.TinTuc;
import com.example.tuan04.service.DanhSachTinTucQuanLyImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "danhSachTinTucServlet", urlPatterns = {"/bai3"})
public class DanhSachTinTucController extends HttpServlet {
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

        switch (action) {
            case "search":
                handleSearch(request, response);
                break;
            case "delete":
                handleDelete(request, response);
                break;
            default:
                showMainPage(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";

        if (action.equals("add")) {
            handleAdd(request, response);
        }
    }

    private void showMainPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("danhSachTinTuc", tinTucService.getDanhSachTinTuc(request.getSession()));
        request.setAttribute("danhSachDanhMuc", tinTucService.getDanhSachDanhMuc(request.getSession()));

        RequestDispatcher rd = request.getRequestDispatcher("DanhSachTinTuc.jsp");
        rd.forward(request, response);
    }

    private void handleAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String maTT = request.getParameter("maTT");
            String tieuDe = request.getParameter("tieuDe");
            String lienKet = request.getParameter("lienKet");
            String noiDung = request.getParameter("noiDung");
            String danhMuc = request.getParameter("danhMuc");

            TinTuc tinTuc = TinTuc.builder()
                    .maTT(maTT)
                    .tieuDe(tieuDe)
                    .lienKet(lienKet)
                    .noiDung(noiDung)
                    .thongTinDanhMuc(danhMuc)
                    .build();

            tinTucService.themTinTuc(request.getSession(), tinTuc);
            request.setAttribute("message", "Thêm tin tức thành công!");
        } catch (Exception e) {
            request.setAttribute("error", "Lỗi: " + e.getMessage());
        }

        showMainPage(request, response);
    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maTT = request.getParameter("maTT");
        tinTucService.xoaTinTuc(request.getSession(), maTT);
        response.sendRedirect("bai3");
    }

    private void handleSearch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String danhMuc = request.getParameter("danhMuc");
        List<TinTuc> ketQua;

        if (danhMuc != null && !danhMuc.trim().isEmpty()) {
            ketQua = tinTucService.timTinTucTheoDanhMuc(request.getSession(), danhMuc);
        } else {
            ketQua = tinTucService.getDanhSachTinTuc(request.getSession());
        }

        request.setAttribute("danhSachTinTuc", ketQua);
        request.setAttribute("danhSachDanhMuc", tinTucService.getDanhSachDanhMuc(request.getSession()));
        request.setAttribute("searchDanhMuc", danhMuc);

        RequestDispatcher rd = request.getRequestDispatcher("DanhSachTinTuc.jsp");
        rd.forward(request, response);
    }
}