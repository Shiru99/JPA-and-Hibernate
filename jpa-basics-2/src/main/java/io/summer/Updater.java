package io.summer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Updater {
    public static void main(String[] args) {
        
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("editor");

        EntityManager entityManager = emFactory.createEntityManager();
        EntityTransaction entityTransaction =  entityManager.getTransaction();
        
        Employee employee =  entityManager.find(Employee.class, 3);
        EmailGroup emailGroup = entityManager.find(EmailGroup.class, 11);

        employee.setEmailGroups(emailGroup);
        emailGroup.setEmployee(employee);

        entityTransaction.begin();

            entityManager.persist(emailGroup);
            entityManager.persist(employee);
            
        entityTransaction.commit();

        entityManager.close();
        emFactory.close();
    }
}
