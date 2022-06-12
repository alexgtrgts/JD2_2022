package it;

import entity.Address;
import org.junit.Assert;
import org.junit.Test;
import util.HibernateUtil;
import javax.persistence.EntityManager;


public class AppTest {

    Address ad = Address.builder()
            .city("NY")
            .street("5th Ave")
            .house("00").build();
    EntityManager entityManager = HibernateUtil.getEntityManager();


//    //добавление в базу
    @Test
    public void createTest() {
        entityManager.getTransaction().begin();
        entityManager.persist(ad);
        Address ad2 = entityManager.find(Address.class, 1);
        entityManager.getTransaction().commit();
        Assert.assertEquals(ad, ad2);
    }

//    //получить из базы
    @Test
    public void getTest() {
        System.out.println(ad);
    }


    //обновить в базе
    @Test
    public void updateTest() {
        entityManager.getTransaction().begin();
        entityManager.persist(ad);
        Address ad2 = entityManager.find(Address.class,1);
        ad2.setCity("Berlin");
        ad2.setHouse("90210");
        entityManager.merge(ad2);
    }


    //удалить из базы
    @Test
    public void deleteTest() {
        entityManager.getTransaction().begin();
        entityManager.remove(ad);
        Address ad5 = entityManager.find(Address.class, 1);
        System.out.println(ad5);
    }
}
