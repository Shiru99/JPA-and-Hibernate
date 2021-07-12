package io.summer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        String qString1 =   "SELECT e.name FROM Employee e"+
                            "   WHERE e.name LIKE 'J%'";

        TypedQuery<String> query1 = entityManager.createQuery(qString1,String.class);
        List<String> resultList1 = query1.getResultList();

        for (String str : resultList1) {
            System.out.println(str);
        }

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        String qString2 =   "SELECT e FROM Employee e"+
                            "   WHERE e.id between 1 and 2";

        TypedQuery<Employee> query2 = entityManager.createQuery(qString2,Employee.class);
        List<Employee> resultList2 = query2.getResultList();

        for (Employee employee : resultList2) {
            System.out.println(employee);
        }


        entityManager.close();
        emFactory.close();
    }
}
