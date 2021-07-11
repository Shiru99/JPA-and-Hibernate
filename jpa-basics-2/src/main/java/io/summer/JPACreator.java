package io.summer;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPACreator 
{
    public static void main( String[] args )
    {
        Employee employee1 = new Employee("John Doe","123456789");
        Employee employee2 = new Employee("Jenny Doe","123456789012",new Date(),EmployeeType.FULL_TIME);
        Employee employee3 = new Employee("James Doe","123456789034",new Date(),EmployeeType.INTERN);

        AccessCard card1 = new AccessCard(new Date(),true,"2.1.2");
        AccessCard card2 = new AccessCard(new Date(),false,"1.0.3");
        
        employee2.setCard(card1);
        card1.setOwner(employee2);
        employee3.setCard(card2);
        card2.setOwner(employee3);

        PayCheck check1 = new PayCheck(new Date(), 20000);
        PayCheck check2 = new PayCheck(new Date(), 50000);
        PayCheck check3 = new PayCheck(new Date(), 50000);

        check1.setEmployee(employee3);
        check2.setEmployee(employee2);
        check3.setEmployee(employee3);
        employee2.setPayChecks(check2);
        employee3.setPayChecks(check1);
        employee3.setPayChecks(check3);
        
        EmailGroup group1 = new EmailGroup("Project Delta");
        EmailGroup group2 = new EmailGroup("Project Alpha");
        EmailGroup group3 = new EmailGroup("Goa Trip");

        group1.setEmployee(employee2);
        employee2.setEmailGroups(group1);
        group1.setEmployee(employee3);
        employee3.setEmailGroups(group1);

        group2.setEmployee(employee1);
        employee1.setEmailGroups(group2);
        group2.setEmployee(employee2);
        employee2.setEmailGroups(group2);

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("creator");

        EntityManager entityManager = emFactory.createEntityManager();
        EntityTransaction entityTransaction =  entityManager.getTransaction();
        
        /* 1. CRUD : Create */ 
        entityTransaction.begin();

            entityManager.persist(employee1);
            entityManager.persist(employee2);
            entityManager.persist(employee3);

            entityManager.persist(card1);
            entityManager.persist(card2);

            entityManager.persist(check1);
            entityManager.persist(check2);
            entityManager.persist(check3);

            entityManager.persist(group1);
            entityManager.persist(group2);
            entityManager.persist(group3);

        entityTransaction.commit();


        entityManager.close();
        emFactory.close();
    }
}
