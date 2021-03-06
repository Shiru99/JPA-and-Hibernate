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
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("editor");
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

        /*  JPQL - joins with relationship

                SQL query   :   "SELECT e.* 
                                    from employee_data e JOIN accesscard a
                                        ON e.card_id = a.id 
                                        AND a.isactive = true
                                ";
                                    
                JPQL        :   "SELECT e from Employee e WHERE e.card.isActive = true";
        */
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        
        String qString3 =   "SELECT e from Employee e WHERE e.card.isActive = true";

        TypedQuery<Employee> query3 = entityManager.createQuery(qString3,Employee.class);
        List<Employee> resultList3 = query3.getResultList();

        for (Employee employee : resultList3) {
            System.out.println(employee);
        }

        /*  Freeform queries & custom result types  */
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        
        String qString4 =   "SELECT e.name, e.card.issuedDate from Employee e";

        TypedQuery<Object[]> query4 = entityManager.createQuery(qString4,Object[].class);
        List<Object[]> resultList4 = query4.getResultList();

        for (Object[] object : resultList4) {
            System.out.println("Name : "+object[0]+" issued Access card on : "+object[1]);
        }

        /*  JPQL parameters to avoid SQL injection - :var */
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        // String id = " 5 ;  DELETE * FROM Employee ";
        // String qString5 =   "SELECT e from Employee e "+
        //                     "   WHERE e.id < " + id
        //                     ;

        String idValue = "5";
        String qString5 =   "SELECT e from Employee e "+
                            "   WHERE e.id < :IDVal"
                            ;
        
        TypedQuery<Employee> query5 = entityManager.createQuery(qString5,Employee.class);
        query5.setParameter("IDVal", Integer.parseInt(idValue));
        List<Employee> resultList5 = query5.getResultList();

        for (Employee employee : resultList5) {
            System.out.println(employee);
        }

        
        /*  Named Queries */
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        TypedQuery<Employee> query6 = entityManager.createNamedQuery("query1",Employee.class);
        List<Employee> resultList6 = query6.getResultList();
        for (Employee employee : resultList6) {
            System.out.println(employee);
        }

        TypedQuery<Employee> query7 = entityManager.createNamedQuery("query2",Employee.class);
        query7.setParameter("status", false);
        List<Employee> resultList7 = query7.getResultList();
        for (Employee employee : resultList7) {
            System.out.println(employee);
        }


        entityManager.close();
        emFactory.close();
    }
}
