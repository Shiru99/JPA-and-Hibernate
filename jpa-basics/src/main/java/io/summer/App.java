package io.summer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *  JPA basics
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Employee> employees = new ArrayList<Employee>(
            Arrays.asList(
                new Employee(2,"Jenny Doe"),    
                new Employee(1,"John Doe"),
                new Employee(3,"James Doe")
            )
        );


        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("myApp");

        EntityManager entityManager = emFactory.createEntityManager();
        EntityTransaction entityTransaction =  entityManager.getTransaction();
        
        entityTransaction.begin();
        for (Employee employee : employees) {
            entityManager.persist(employee);
        }
        entityTransaction.commit();
    }
}
