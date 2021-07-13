package io.summer.springbootwithjpa;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import io.summer.model.Employee;
import io.summer.model.EmployeeType;

@SpringBootApplication
@EntityScan(basePackages = "io.summer")
public class SpringBootWithJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithJpaApplication.class, args);
	}
	
	// M-1
	// @PersistenceUnit
	// private EntityManagerFactory emf;

	// M-2
	// @PersistenceContext(type = PersistenceContextType.EXTENDED) // ensures - Thread-Safety
	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct 					/* Run Custom Method ==> PostConstruct */
	public void start() 
	{
		Employee employee = new Employee("James","3456789012",new Date(),EmployeeType.INTERN);

		/*	M-1 

		EntityManager entityManager = emf.createEntityManager();	
        EntityTransaction entityTransaction =  entityManager.getTransaction();

		entityTransaction.begin();
            entityManager.persist(employee);
		entityTransaction.commit();

		entityManager.close();
		emf.close();

		*/

		/* M-2 

			This is shared PersistenceContext (need to be thread-safe, multiple processes using same PersistenceContext can turn into unpredictable results)

			1. Error : Not allowed to create transaction on shared EntityManager - use Spring transactions or EJB CMT instead ==> PersistenceContextType.EXTENDED

			BUT we can perform read operation
		*/

		// NO transaction allowed unless ensures - Thread-Safety
		// EntityTransaction entityTransaction =  entityManager.getTransaction();
		// entityTransaction.begin();
            // entityManager.persist(employee);
		// entityTransaction.commit();
		// entityManager.flush();


		// Reading allowed
		Employee e = entityManager.find(Employee.class, 1);
		System.out.println(e);

	}
}