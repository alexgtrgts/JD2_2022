package DAO;

import Entity.Manufacturer;
import org.junit.jupiter.api.Test;

import static DAO.DAOManufacturerImpl.em;

class DAOManufacturerImplTest {

    @Test
    void listAll() {
    }

    @Test
    void create() {
        Manufacturer manufacturer = Manufacturer.builder()
                .name("Agat")
                .address("220078, Minks,Golodeda,25")
                .brand("AG")
                .build();
        em.getTransaction().begin();
        em.persist(manufacturer);
        em.getTransaction().commit();
    }

    @Test
    void read() {
        Manufacturer manufacturer = Manufacturer.builder()
                .name("MMZ")
                .address("220000, Minsk,Nezavisimosti,1")
                .brand("MMZ")
                .build();
        em.getTransaction().begin();
        em.persist(manufacturer);
        em.getTransaction().commit();
        Manufacturer manufacturer1 = (Manufacturer) em.find(Manufacturer.class, manufacturer.getId());
    }

    @Test
    void update() {
        em.getTransaction().begin();
        Manufacturer manufacturer = Manufacturer.builder()
                .name("MMZ")
                .address("220000, Minsk,Nezavisimosti,1")
                .brand("MMZ")
                .build();
        manufacturer.setBrand("AAA");
        em.merge(manufacturer);
        em.getTransaction().commit();
    }

    @Test
    void delete() {
        em.getTransaction().begin();
        Manufacturer manufacturer = Manufacturer.builder()
                .name("MMZ")
                .address("220000, Minsk,Nezavisimosti,1")
                .brand("MMZ")
                .build();
        em.persist(manufacturer);
        em.remove(manufacturer);
        em.getTransaction().commit();
    }
}