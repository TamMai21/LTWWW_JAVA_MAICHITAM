package com.example.tuan04.service;

import com.example.tuan04.model.TinTuc;
import com.example.tuan04.model.DanhMuc;
import com.example.tuan04.service.interf.DanhSachTinTucQuanLy;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DanhSachTinTucQuanLyImpl implements DanhSachTinTucQuanLy {

    private static final Pattern URL_PATTERN = Pattern.compile("^https?://.*");
    private static final Pattern CONTENT_LENGTH_PATTERN = Pattern.compile("^.{1,255}$");

    @Override
    public List<TinTuc> getDanhSachTinTuc(HttpSession session) {
        List<TinTuc> danhSach = (List<TinTuc>) session.getAttribute("danhSachTinTuc");
        if (danhSach == null) {
            danhSach = new ArrayList<>();
            // Khởi tạo dữ liệu mẫu
            danhSach.add(TinTuc.builder()
                    .maTT("TT001")
                    .tieuDe("Tin tức công nghệ mới")
                    .lienKet("https://example.com/tech-news")
                    .noiDung("Nội dung tin tức về công nghệ mới nhất...")
                    .thongTinDanhMuc("CNTT")
                    .build());
            session.setAttribute("danhSachTinTuc", danhSach);
        }
        return danhSach;
    }

    @Override
    public List<DanhMuc> getDanhSachDanhMuc(HttpSession session) {
        List<DanhMuc> danhSach = (List<DanhMuc>) session.getAttribute("danhSachDanhMuc");
        if (danhSach == null) {
            danhSach = new ArrayList<>();
            // Khởi tạo dữ liệu mẫu
            danhSach.add(DanhMuc.builder().madm("CNTT").tendm("Công nghệ thông tin").nguoiQuanLy("Admin").ghiChu("Danh mục IT").build());
            danhSach.add(DanhMuc.builder().madm("SPORT").tendm("Thể thao").nguoiQuanLy("Editor").ghiChu("Danh mục thể thao").build());
            danhSach.add(DanhMuc.builder().madm("NEWS").tendm("Tin tức tổng hợp").nguoiQuanLy("Reporter").ghiChu("Tin tức chung").build());
            session.setAttribute("danhSachDanhMuc", danhSach);
        }
        return danhSach;
    }

    @Override
    public void themTinTuc(HttpSession session, TinTuc tinTuc) {
        if (isValidTinTuc(tinTuc)) {
            List<TinTuc> danhSach = getDanhSachTinTuc(session);
            danhSach.add(tinTuc);
        } else {
            throw new IllegalArgumentException("Dữ liệu tin tức không hợp lệ");
        }
    }

    @Override
    public void xoaTinTuc(HttpSession session, String maTT) {
        List<TinTuc> danhSach = getDanhSachTinTuc(session);
        danhSach.removeIf(tt -> tt.getMaTT().equals(maTT));
    }

    @Override
    public TinTuc timTinTuc(HttpSession session, String maTT) {
        List<TinTuc> danhSach = getDanhSachTinTuc(session);
        return danhSach.stream()
                .filter(tt -> tt.getMaTT().equals(maTT))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<TinTuc> timTinTucTheoDanhMuc(HttpSession session, String maDanhMuc) {
        List<TinTuc> danhSach = getDanhSachTinTuc(session);
        return danhSach.stream()
                .filter(tt -> tt.getThongTinDanhMuc().equals(maDanhMuc))
                .collect(Collectors.toList());
    }

    private boolean isValidTinTuc(TinTuc tinTuc) {
        // Kiểm tra các trường bắt buộc
        if (tinTuc.getMaTT() == null || tinTuc.getMaTT().trim().isEmpty() ||
                tinTuc.getTieuDe() == null || tinTuc.getTieuDe().trim().isEmpty() ||
                tinTuc.getLienKet() == null || tinTuc.getLienKet().trim().isEmpty() ||
                tinTuc.getNoiDung() == null || tinTuc.getNoiDung().trim().isEmpty()) {
            return false;
        }

        // Kiểm tra định dạng URL
        if (!URL_PATTERN.matcher(tinTuc.getLienKet()).matches()) {
            return false;
        }

        // Kiểm tra độ dài nội dung (tối đa 255 ký tự)
        if (!CONTENT_LENGTH_PATTERN.matcher(tinTuc.getNoiDung()).matches()) {
            return false;
        }

        return true;
    }
}