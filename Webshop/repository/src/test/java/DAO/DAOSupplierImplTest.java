package DAO;

import Entity.Supplier;
import org.junit.jupiter.api.Test;

import static DAO.DAOManufacturerImpl.em;

class DAOSupplierImplTest {

    @Test
    void create() {
        Supplier supplier = Supplier.builder()
                .name("DANA")
                .address("220003, Minks,Mayak,1")
                .vatNumber("009569812")
                .build();
        em.getTransaction().begin();
        em.persist(supplier);
        em.getTransaction().commit();
    }

    @Test
    void read() {
        Supplier supplier = Supplier.builder()
                .name("SevernyiVeter")
                .address("229999, Minsk,Rokossovskogo,15")
                .vatNumber("015678539")
                .build();
        em.getTransaction().begin();
        em.persist(supplier);
        em.getTransaction().commit();
        Supplier supplier1 = (Supplier) em.find(Supplier.class, supplier.getId());
    }

    @Test
    void listAll() {
    }

    @Test
    void update() {
        em.getTransaction().begin();
        Supplier supplier = Supplier.builder()
                .name("Evrotorg")
                .address("220001, Minsk,Promyshlennaya,1")
                .vatNumber("688089134")
                .build();
        supplier.setName("Evroopt");
        em.merge(supplier);
        em.getTransaction().commit();
    }

    @Test
    void delete() {
        em.getTransaction().begin();
        Supplier supplier = Supplier.builder()
                .name("1AKB")
                .address("221313,Minsk,Centralnaya,1")
                .vatNumber("198001002")
                .build();
        em.persist(supplier);
        em.remove(supplier);
        em.getTransaction().commit();
    }
}