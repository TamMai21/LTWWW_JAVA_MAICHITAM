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
import java.util.regex.Pattern;

@WebServlet(name = "tinTucFormServlet", urlPatterns = {"/addNews"})
public class TinTucFormController extends HttpServlet {
    private DanhSachTinTucQuanLyImpl tinTucService;
    private static final Pattern URL_PATTERN = Pattern.compile("^https?://.*");
    private static final Pattern CONTENT_LENGTH_PATTERN = Pattern.compile("^.{1,255}$");

    @Override
    public void init() {
        this.tinTucService = new DanhSachTinTucQuanLyImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("danhSachDanhMuc", tinTucService.getDanhSachDanhMuc(request.getSession()));
        RequestDispatcher rd = request.getRequestDispatcher("TinTucForm.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maTT = request.getParameter("maTT");
        String tieuDe = request.getParameter("tieuDe");
        String lienKet = request.getParameter("lienKet");
        String noiDung = request.getParameter("noiDung");
        String danhMuc = request.getParameter("danhMuc");

        // Validation
        StringBuilder errors = new StringBuilder();

        if (maTT == null || maTT.trim().isEmpty()) {
            errors.append("Mã TT không được để trống. ");
        }
        if (tieuDe == null || tieuDe.trim().isEmpty()) {
            errors.append("Tiêu đề không được để trống. ");
        }
        if (lienKet == null || lienKet.trim().isEmpty()) {
            errors.append("Liên kết không được để trống. ");
        } else if (!URL_PATTERN.matcher(lienKet).matches()) {
            errors.append("Liên kết phải bắt đầu bằng http://. ");
        }
        if (noiDung == null || noiDung.trim().isEmpty()) {
            errors.append("Nội dung không được để trống. ");
        } else if (!CONTENT_LENGTH_PATTERN.matcher(noiDung).matches()) {
            errors.append("Nội dung không quá 255 ký tự. ");
        }

        if (errors.length() > 0) {
            request.setAttribute("error", errors.toString());
            request.setAttribute("danhSachDanhMuc", tinTucService.getDanhSachDanhMuc(request.getSession()));
            RequestDispatcher rd = request.getRequestDispatcher("TinTucForm.jsp");
            rd.forward(request, response);
            return;
        }

        try {
            TinTuc tinTuc = TinTuc.builder()
                    .maTT(maTT)
                    .tieuDe(tieuDe)
                    .lienKet(lienKet)
                    .noiDung(noiDung)
                    .thongTinDanhMuc(danhMuc)
                    .build();

            tinTucService.themTinTuc(request.getSession(), tinTuc);

            // Redirect về trang danh sách
            response.sendRedirect(request.getContextPath() + "/bai3");
        } catch (Exception e) {
            request.setAttribute("error", "Lỗi: " + e.getMessage());
            request.setAttribute("danhSachDanhMuc", tinTucService.getDanhSachDanhMuc(request.getSession()));
            RequestDispatcher rd = request.getRequestDispatcher("TinTucForm.jsp");
            rd.forward(request, response);
        }
    }
}