package io.summer;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class JPQL 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("creator");
        EntityManager entityManager = emFactory.createEntityManager();

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        /*
            SQL query   :   "select * from employee_data;"
            JPQL        :   "select e from Employee e"      // (class name)
        */

        // Query query = entityManager.createQuery("select e from Employee e");
        // List resultList = query.getResultList();

        String qString =  "SELECT e FROM Employee e"+
                    "   WHERE id>1"+
                    "   ORDER BY e.name ASC";

        TypedQuery<Employee> query = entityManager.createQuery(qString,Employee.class);
        List<Employee> resultList = query.getResultList();

        // resultList.forEach(System.out::println);
        for (Employee e : resultList) {
            System.out.println(e);
        }

        entityManager.close();
        emFactory.close();
    }
}
