package DAO;

import Entity.Seller;
import org.junit.jupiter.api.Test;

import static DAO.DAOManufacturerImpl.em;

class DAOSellerImplTest {

    @Test
    void listAll() {
    }

    @Test
    void create() {
        Seller seller = Seller.builder()
                .name("BME")
                .address("220001, Minks,Skryganova,2")
                .tel("+375295000000")
                .build();
        em.getTransaction().begin();
        em.persist(seller);
        em.getTransaction().commit();
    }

    @Test
    void read() {
        Seller seller = Seller.builder()
                .name("MAN")
                .address("220015, Minsk,Tavlaya,20")
                .tel("=375256999111")
                .build();
        em.getTransaction().begin();
        em.persist(seller);
        em.getTransaction().commit();
        Seller seller1 = (Seller) em.find(Seller.class,seller.getId());
    }

    @Test
    void update() {
        em.getTransaction().begin();
        Seller seller = Seller.builder()
                .name("Kanimis")
                .address("221213, Minsk,Cetkin,18")
                .tel("+375290010002")
                .build();
        seller.setName("KAMO");
        em.merge(seller);
        em.getTransaction().commit();
    }

    @Test
    void delete() {
        em.getTransaction().begin();
        Seller seller = Seller.builder()
                .name("MZSH")
                .address("226768,Minsk,Proletarskaya,50")
                .tel("80173880000")
                .build();
        em.persist(seller);
        em.remove(seller);
        em.getTransaction().commit();
    }
}