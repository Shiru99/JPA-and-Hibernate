package io.summer;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPA_PersistanceContext 
{
    public static void main( String[] args )
    {
        Employee employee1 = new Employee("James Doe","123456789012",new Date(),EmployeeType.INTERN);

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("creator");

        EntityManager entityManager = emFactory.createEntityManager();
        EntityTransaction entityTransaction =  entityManager.getTransaction();
        
        entityTransaction.begin();
            entityManager.persist(employee1);
        entityTransaction.commit();

        entityManager.close();
        emFactory.close();
    }
}
