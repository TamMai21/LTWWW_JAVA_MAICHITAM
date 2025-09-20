package com.example.tuan04.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TinTuc {
    private String maTT;
    private String tieuDe;
    private String lienKet;
    private String noiDung;
    private String thongTinDanhMuc;
}