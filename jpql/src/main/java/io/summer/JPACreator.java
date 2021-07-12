package io.summer;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPACreator 
{
    public static void main( String[] args )
    {
        Employee employee1 = new Employee("John Doe","123456789");
        Employee employee2 = new Employee("Jenny Doe","123456789012",new Date(),EmployeeType.FULL_TIME);
        Employee employee3 = new Employee("James Doe","123456789034",new Date(),EmployeeType.INTERN);

        AccessCard card1 = new AccessCard(new Date(),true,"2.1.2");
        AccessCard card2 = new AccessCard(new Date(),false,"1.0.3");
        
        employee2.setCard(card1);
        card1.setOwner(employee2);
        employee3.setCard(card2);
        card2.setOwner(employee3);

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("creator");

        EntityManager entityManager = emFactory.createEntityManager();
        EntityTransaction entityTransaction =  entityManager.getTransaction();
        
        /* 1. CRUD : Create */ 
        entityTransaction.begin();

            entityManager.persist(employee1);
            entityManager.persist(employee2);
            entityManager.persist(employee3);

            entityManager.persist(card1);
            entityManager.persist(card2);

        entityTransaction.commit();

        entityManager.close();
        emFactory.close();
    }
}
