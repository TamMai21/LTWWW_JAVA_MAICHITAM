package com.example.tuan03.model;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private static final List<Product> ds = new ArrayList<Product>();
    static {
        initData();
    }

    public static List<Product> queryProducts() {
        return ds;
    }

    private static void initData() {
        Product sp = new Product();
        sp.setId("PR001");
        sp.setDescription("");
        sp.setPrice(59000);
        ds.add(sp);

        sp = new Product();
        sp.setId("PR002");
        sp.setDescription("");
        sp.setPrice(48000);
        ds.add(sp);

        sp = new Product();
        sp.setId("PR003");
        sp.setDescription("");
        sp.setPrice(52000);
        ds.add(sp);

        sp = new Product();
        sp.setId("PR004");
        sp.setDescription("");
        sp.setPrice(83000);
        ds.add(sp);

        sp = new Product();
        sp.setId("PR005");
        sp.setDescription("");
        sp.setPrice(71000);
        ds.add(sp);

        sp.setModel("Nokia Lumia");
        sp.setQuantity(10);
        sp.setImgURL("/images/dt1.jpg");

        sp.setModel("BlackBerry Passport");
        sp.setQuantity(10);
        sp.setImgURL("/images/dt2.jpg");

        sp.setModel("Sony Xperia Z5");
        sp.setQuantity(10);
        sp.setImgURL("/images/dt3.jpg");

        sp.setModel("HTC One M9");
        sp.setQuantity(10);
        sp.setImgURL("/images/dt4.jpg");

        sp.setModel("Samsung Galaxy Note 5");
        sp.setQuantity(10);
        sp.setImgURL("/images/dt5.png");
    }
}
