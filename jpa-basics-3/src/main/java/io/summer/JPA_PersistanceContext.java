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
        String hash = " ################################# ";
        Employee james = new Employee("James Doe","123456789012",new Date(),EmployeeType.INTERN);

        System.out.println(hash+"Employee Instance Created"+hash);

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("creator");
        System.out.println(hash+"Schema Created"+hash);
        EntityManager entityManager = emFactory.createEntityManager();
        EntityTransaction entityTransaction =  entityManager.getTransaction();
        
        entityTransaction.begin();
        System.out.println(hash+"Started Transaction"+hash);

            System.out.println(entityManager.find(Employee.class,1));  // null

            entityManager.persist(james);
            System.out.println(hash+"After Persist method"+hash);
            Employee employee = entityManager.find(Employee.class,1);
            /* 
                employeeType=INTERN, id=1, lastUpdateAt=Mon Jul 12 16:10:29 IST 2021, name=James Doe, ssn=123456789012
            */ 
            
            // ----------------------------- flush() Detach() merge() -----------------------------
            entityManager.flush();
            entityManager.detach(employee);
            /* To detach all entities from persistence context at that moment => clear */ 
            // entityManager.clear();   

            employee.setName("What's in a name");
            System.out.println(entityManager.find(Employee.class,1));
            /* 
                employeeType=INTERN, id=1, lastUpdateAt=Mon Jul 12 16:10:29 IST 2021, name=James Doe, ssn=123456789012
            */ 

            entityManager.merge(employee);
            System.out.println(entityManager.find(Employee.class,1));
            /* 
                employeeType=INTERN, id=1, lastUpdateAt=Mon Jul 12 16:18:54 IST 2021, name=What Is In The Name!, ssn=123456789012
            */

            // ----------------------------- refresh() -----------------------------

            Employee tEmployee = entityManager.find(Employee.class,1);
            System.out.println(tEmployee);

            tEmployee.setEmployeeType(EmployeeType.FULL_TIME);
            System.out.println(tEmployee);

            entityManager.refresh(tEmployee);   // reset the entity 
            System.out.println(tEmployee);

        entityTransaction.commit();
        System.out.println(hash+"After Commit method"+hash);

        entityManager.close();
        emFactory.close();
    }
}
