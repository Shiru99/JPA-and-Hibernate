package io.summer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Reader {
    public static void main(String[] args) {

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("reader");
        EntityManager entityManager = emFactory.createEntityManager();

        Employee employee =  entityManager.find(Employee.class, 2);
        System.out.println(employee);

        AccessCard card = entityManager.find(AccessCard.class, 4);
        System.out.println(card.getOwner());

        PayCheck check = entityManager.find(PayCheck.class, 6);
        System.out.println(check);
        System.out.println(check.getEmployee());

    }
}
