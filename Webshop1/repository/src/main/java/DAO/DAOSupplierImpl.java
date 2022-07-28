package DAO;

import Entity.Supplier;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import static DAO.DAOManufacturerImpl.em;

public class DAOSupplierImpl implements DAOSupplier {

    @Override
    public void create(Supplier supplier) throws SQLException, ClassNotFoundException {
        em.getTransaction().begin();
        em.persist(supplier);
        em.getTransaction().commit();
    }

    @Override
    public Supplier read(Serializable id) throws SQLException, ClassNotFoundException {
        em.getTransaction().begin();
        Supplier supplier = em.find(Supplier.class, id);
        return supplier;
    }

    @Override
    public List<Supplier> listAll() throws SQLException, ClassNotFoundException {
        em.getTransaction().begin();
        List<Supplier> supplierList = (List) em.createQuery("SELECT S from Supplier S").getResultList();
        em.getTransaction().commit();
        return supplierList;
    }

    @Override
    public Supplier update(Supplier supplier) throws SQLException, ClassNotFoundException {
        //em.getTransaction().begin();
        Supplier supplier1 = em.merge(supplier);
        em.getTransaction().commit();
        return supplier1;
    }

    @Override
    public void delete(Serializable id) throws SQLException, ClassNotFoundException {
        Supplier supplier = (Supplier) em.find(Supplier.class, id);
        em.getTransaction().begin();
        em.remove(supplier);
        em.getTransaction().commit();
    }
}
