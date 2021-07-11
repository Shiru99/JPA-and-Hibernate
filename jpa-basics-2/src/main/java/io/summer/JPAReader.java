package io.summer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAReader {
    public static void main(String[] args) {

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("reader");
        EntityManager entityManager = emFactory.createEntityManager();

        Employee employee =  entityManager.find(Employee.class, 3);
        System.out.println(employee);

        AccessCard card = entityManager.find(AccessCard.class, 4);
        System.out.println(card.getOwner());

        PayCheck check = entityManager.find(PayCheck.class, 6);
        System.out.println(check.getEmployee());
        System.out.println(employee.getPayChecks());

        EmailGroup emailGroup = entityManager.find(EmailGroup.class, 10);
        System.out.println(emailGroup);
        System.out.println(emailGroup.getEmployee());

    }
}
