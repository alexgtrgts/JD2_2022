package DAO;

import Entity.Product;
import org.junit.jupiter.api.Test;

import static DAO.DAOManufacturerImpl.em;

class DAOProductImplTest {

    @Test
    void listAll() {
    }

    @Test
    void create() {
        Product product = Product.builder()
                .name("лопата")
                .description("малая саперная")
                .price(5.0)
                .type("шанцевый инструмент")
                .build();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }

    @Test
    void read() {
        Product product = Product.builder()
                .name("телефон")
                .type("мобильный")
                .description("без чехла")
                .price(500.0)
                .build();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        Product product1 = (Product) em.find(Product.class,product.getId());
    }

    @Test
    void update() {
        em.getTransaction().begin();
        Product product = Product.builder()
                .name("стол")
                .description("кухонный")
                .type("на ножках")
                .price(50.0)
                .build();
        product.setPrice(100.0);
        em.merge(product);
        em.getTransaction().commit();
    }

    @Test
    void delete() {
        em.getTransaction().begin();
        Product product = Product.builder()
                .name("весло")
                .description("для лодки")
                .price(1.0)
                .type("хорошее")
                .build();
        em.persist(product);
        em.remove(product);
        em.getTransaction().commit();
    }
}