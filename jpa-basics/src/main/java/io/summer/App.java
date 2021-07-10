package io.summer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
        Date d1  = new GregorianCalendar(1924, Calendar.FEBRUARY, 31).getTime(); // 2nd March
        Date d2  = new GregorianCalendar(1923, Calendar.APRIL, 1).getTime();

        List<Employee> employees = new ArrayList<Employee>(
            Arrays.asList(
                new Employee(1,"John Doe","123456789"),
                new Employee(3,"Jenny Doe","123456789012",29,d1,new Date(),EmployeeType.FULL_TIME),    
                new Employee(2,"James Doe","123456789034",30,d2,new Date(),EmployeeType.INTERN)
            )
        );


        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("myApp");

        EntityManager entityManager = emFactory.createEntityManager();
        EntityTransaction entityTransaction =  entityManager.getTransaction();
        
        /* 1. CRUD : Create */ 
        entityTransaction.begin();
        for (Employee employee : employees) {
            // entityManager.persist(employee);
        }
        entityTransaction.commit();

        
        /*  2. CRUD : Read
            
                SELECT * FROM EMPLOYEE_DATA where id=1; 

                for 
                
                    invalid id = 21     ==> null 
                    String id = "2"     ==> Error
        */ 
        int id = 3;
        Employee employee = entityManager.find(Employee.class, id); 
        System.out.println(employee);



        /*  3. CRUD : Update */
        employee.setEmployeeType(EmployeeType.FULL_TIME);
        System.out.println(employee);
        entityTransaction.begin();
        entityManager.persist(employee);
        entityTransaction.commit();

        

        entityManager.close();
        emFactory.close();
    }
}
