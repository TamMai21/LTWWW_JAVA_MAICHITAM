package com.example.tuan04.model;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DanhMuc {
    private String madm;
    private String tendm;
    private String nguoiQuanLy;
    private String ghiChu;
    private List<TinTuc> danhSachTinTuc;
}