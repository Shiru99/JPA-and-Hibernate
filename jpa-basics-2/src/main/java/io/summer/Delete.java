package io.summer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("editor");

        EntityManager entityManager = emFactory.createEntityManager();
        EntityTransaction entityTransaction =  entityManager.getTransaction();

        Employee employee =  entityManager.find(Employee.class, 2);

        entityTransaction.begin();
            entityManager.remove(employee);
            /*
                for ID = 1 :
                    removes from employee_data & email_group_subscription

                for ID = 2 :

                    ERROR: update or delete on table "employee_data" violates foreign key constraint "fk9n3qqw1iqk7r7ofm56oc3ctc1" on table "paycheck" 

                    Deleting from paycheck may result into data loss ==> set cascade
             */
        entityTransaction.commit();

        entityManager.close();
        emFactory.close();

    }
}
