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
        Employee employee = new Employee("James Doe","123456789012",new Date(),EmployeeType.INTERN);

        System.out.println(hash+"Employee Instance Created"+hash);

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("creator");
        System.out.println(hash+"Schema Created"+hash);
        EntityManager entityManager = emFactory.createEntityManager();
        EntityTransaction entityTransaction =  entityManager.getTransaction();
        
        entityTransaction.begin();
        System.out.println(hash+"Started Transaction"+hash);

            Employee employee1 = entityManager.find(Employee.class,1);
            System.out.println(employee1);      // null

            entityManager.persist(employee);
            System.out.println(hash+"After Persist method"+hash);

            Employee employee2 = entityManager.find(Employee.class,1);
            System.out.println(employee2);  

        entityTransaction.commit();
        System.out.println(hash+"After Commit method"+hash);

        entityManager.close();
        emFactory.close();
    }
}
