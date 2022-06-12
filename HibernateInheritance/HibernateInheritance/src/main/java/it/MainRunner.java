package it;


import Util.HibernateUtil;

import javax.persistence.EntityManager;

public class MainRunner {
    public static void main(String[] args) {
        WorkTask wt = new WorkTask(7.98);
        HomeTask ht = new HomeTask("11-04-2022","12-04-2022");
        wt.setName("digging a hole");
        wt.setDescription("to dig a hole");
        ht.setName("exercise");
        ht.setDescription("to do an exercise");
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(wt);
        em.persist(ht);
        em.getTransaction().commit();
    }
}
