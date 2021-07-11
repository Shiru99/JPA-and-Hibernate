package io.summer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Reader {
    public static void main(String[] args) {

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("reader");
        EntityManager entityManager = emFactory.createEntityManager();

        Employee employee =  entityManager.find(Employee.class, 2);
        System.out.println(employee);

    }
}
