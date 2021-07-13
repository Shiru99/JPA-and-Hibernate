package io.summer.springbootwithjpa;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
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
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@PostConstruct 					/* Run Custom Method ==> PostConstruct */
	public void start() 
	{
		Employee employee = new Employee("James","3456789012",new Date(),EmployeeType.INTERN);

		EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction =  entityManager.getTransaction();

		entityTransaction.begin();
            entityManager.persist(employee);
		entityTransaction.commit();

		entityManager.close();
		emf.close();
	}
	
}
