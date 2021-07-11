package io.summer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {

        List<Employee> employees = new ArrayList<Employee>(
            Arrays.asList(
                new Employee("John Doe","123456789"),
                new Employee("Jenny Doe","123456789012",new Date(),EmployeeType.FULL_TIME),    
                new Employee("James Doe","123456789034",new Date(),EmployeeType.INTERN)
            )
        );

        AccessCard card1 = new AccessCard(new Date(),true,"2.1.2");
        AccessCard card2 = new AccessCard(new Date(),false,"1.0.3");

        PayCheck check1 = new PayCheck(new Date(), 20000);
        PayCheck check2 = new PayCheck(new Date(), 50000);


        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("myApp");

        EntityManager entityManager = emFactory.createEntityManager();
        EntityTransaction entityTransaction =  entityManager.getTransaction();
        
        /* 1. CRUD : Create */ 
        entityTransaction.begin();

            for (Employee employee : employees) {
                entityManager.persist(employee);
            }

            entityManager.persist(card1);
            entityManager.persist(card2);

            entityManager.persist(check1);
            entityManager.persist(check2);

        entityTransaction.commit();


        entityManager.close();
        emFactory.close();
    }
}
