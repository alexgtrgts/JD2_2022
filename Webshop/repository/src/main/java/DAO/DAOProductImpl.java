package DAO;

import Entity.Manufacturer;
import Entity.Product;
import Util.HibernateUtil;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class DAOProductImpl implements DAOProduct {

    public static final EntityManager em = HibernateUtil.getentityManager();

    @Override
    public List<Product> listAll() throws SQLException, ClassNotFoundException {
        em.getTransaction().begin();
        List<Product> productList = (List) em.createQuery("SELECT P from Product p").getResultList();
        em.getTransaction().commit();
        return productList;
    }

    @Override
    public void create(Product product) throws SQLException, ClassNotFoundException {
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }

    @Override
    public Product read(Serializable id) throws SQLException, ClassNotFoundException {
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        return product;
    }

    @Override
    public Product update(Product product) throws SQLException, ClassNotFoundException {
        em.getTransaction().begin();
        Product product1 = em.merge(product);
        em.getTransaction().commit();
        return product1;
    }

    @Override
    public void delete(Product product) throws SQLException, ClassNotFoundException {
        em.getTransaction().begin();
        em.remove(product);
        em.getTransaction().commit();
    }
}
