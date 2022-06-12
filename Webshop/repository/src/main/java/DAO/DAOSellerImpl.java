package DAO;

import Entity.Manufacturer;
import Entity.Seller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import static DAO.DAOManufacturerImpl.em;

public class DAOSellerImpl implements DAOSeller {
    @Override
    public List<Seller> listAll() throws SQLException, ClassNotFoundException {
        em.getTransaction().begin();
        List<Seller> sellerList = (List) em.createQuery("SELECT S from Seller s").getResultList();
        em.getTransaction().commit();
        return sellerList;
    }

    @Override
    public void create(Seller seller) throws SQLException, ClassNotFoundException {
        em.getTransaction().begin();
        em.persist(seller);
        em.getTransaction().commit();
    }

    @Override
    public Seller read(Serializable id) throws SQLException, ClassNotFoundException {
        em.getTransaction().begin();
        Seller seller = em.find(Seller.class, id);
        return seller;
    }

    @Override
    public Seller update(Seller seller) throws SQLException, ClassNotFoundException {
        em.getTransaction().begin();
        Seller seller1 = em.merge(seller);
        em.getTransaction().commit();
        return seller1;
    }

    @Override
    public void delete(Seller seller) throws SQLException, ClassNotFoundException {
        em.getTransaction().begin();
        em.remove(seller);
        em.getTransaction().commit();
    }
}
