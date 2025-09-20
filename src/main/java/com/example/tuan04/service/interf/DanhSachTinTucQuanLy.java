package com.example.tuan04.service.interf;

import com.example.tuan04.model.TinTuc;
import com.example.tuan04.model.DanhMuc;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public interface DanhSachTinTucQuanLy {
    List<TinTuc> getDanhSachTinTuc(HttpSession session);
    List<DanhMuc> getDanhSachDanhMuc(HttpSession session);
    void themTinTuc(HttpSession session, TinTuc tinTuc);
    void xoaTinTuc(HttpSession session, String maTT);
    TinTuc timTinTuc(HttpSession session, String maTT);
    List<TinTuc> timTinTucTheoDanhMuc(HttpSession session, String maDanhMuc);
}