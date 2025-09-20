package com.example.tuan04;

import com.example.tuan04.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // Tạo EntityManagerFactory từ persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("user-management");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Product p1 = Product.builder()
                    .model("Laptop Dell XPS")
                    .description("Laptop cao cấp cho dân lập trình")
                    .quantity(10)
                    .price(2000.0)
                    .imgURL("https://example.com/laptop.jpg")
                    .build();

            Product p2 = Product.builder()
                    .model("iPhone 15 Pro")
                    .description("Điện thoại thông minh mới nhất của Apple")
                    .quantity(20)
                    .price(1200.0)
                    .imgURL("https://example.com/iphone.jpg")
                    .build();

            Product p3 = Product.builder()
                    .model("Sony WH-1000XM5")
                    .description("Tai nghe chống ồn cao cấp")
                    .quantity(15)
                    .price(400.0)
                    .imgURL("https://example.com/headphones.jpg")
                    .build();

            em.persist(p1);
            em.persist(p2);
            em.persist(p3);

            em.getTransaction().commit();

            System.out.println("✅ Đã thêm 3 product vào database!");
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}
