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


        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("myApp");

        EntityManager entityManager = emFactory.createEntityManager();
        EntityTransaction entityTransaction =  entityManager.getTransaction();
        
        /* 1. CRUD : Create */ 
        entityTransaction.begin();
        for (Employee employee : employees) {
            entityManager.persist(employee);
        }
        entityTransaction.commit();

        
        /*  2. CRUD : Read */ 
        int id = 3;
        Employee employee = entityManager.find(Employee.class, id); 
        System.out.println(employee);


        /*  3. CRUD : Update */
        employee.setEmployeeType(EmployeeType.FULL_TIME);
        entityTransaction.begin();
        entityManager.persist(employee);
        entityTransaction.commit();

        
        /*  4. CRUD : Delete */
        employee = entityManager.find(Employee.class, 1);
        entityTransaction.begin();
        entityManager.remove(employee);
        entityTransaction.commit();
        

        entityManager.close();
        emFactory.close();
    }
}
