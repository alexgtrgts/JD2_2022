package DAO;

import Entity.Manufacturer;
import Util.HibernateUtil;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class DAOManufacturerImpl implements DAOManufacturer {

    public static final EntityManager em = HibernateUtil.getentityManager();

    @Override
    public List<Manufacturer> listAll() throws SQLException, ClassNotFoundException {
        em.getTransaction().begin();
        List<Manufacturer> manufacturerList = (List) em.createQuery("SELECT M from Manufacturer m").getResultList();
        em.getTransaction().commit();
        return manufacturerList;
    }

    @Override
    public void create(Manufacturer manufacturer) throws SQLException, ClassNotFoundException {
        em.getTransaction().begin();
        em.persist(manufacturer);
        em.getTransaction().commit();
    }

    @Override
    public Manufacturer read(Serializable id) throws SQLException, ClassNotFoundException {
        em.getTransaction().begin();
        Manufacturer manufacturer = em.find(Manufacturer.class, id);
        return manufacturer;
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) throws SQLException, ClassNotFoundException {
        em.getTransaction().begin();
        Manufacturer manufacturer1 = em.merge(manufacturer);
        em.getTransaction().commit();
        return manufacturer;
    }

    @Override
    public void delete(Serializable id) throws SQLException, ClassNotFoundException {
        Manufacturer manufacturer = (Manufacturer) em.find(Manufacturer.class, id);
        em.getTransaction().begin();
        em.remove(manufacturer);
        em.getTransaction().commit();
    }
}
