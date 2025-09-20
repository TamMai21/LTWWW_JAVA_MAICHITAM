package com.example.tuan04.service;

import com.example.tuan04.model.Product;
import com.example.tuan04.service.interf.ProductDAO;
import com.example.tuan04.util.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import org.mariadb.jdbc.Connection;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private final DataSource datasource;
    public ProductDAOImpl(DataSource datasource) {
        this.datasource = datasource;
    }
    @Override
    public List<Product> findAll() {
        String sql = "SELECT id, model, description, quantity, price, imgURL FROM product";
        List<Product> list = new ArrayList<>();
        try (
                Connection con = (Connection) this.datasource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("id");
                String model = rs.getString("model");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String imgURL = rs.getString("imgURL");

                list.add(Product.builder()
                        .id(id)
                        .model(model)
                        .description(description)
                        .quantity(quantity)
                        .price(price)
                        .imgURL(imgURL)
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> findAll2() {
        List<Product> listProduct = new ArrayList<>();
        try (EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager()) {
            // Truy vấn JPQL, lấy tất cả Product
            listProduct = entityManager.createQuery("SELECT p FROM Product p", Product.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProduct;
    }



}
