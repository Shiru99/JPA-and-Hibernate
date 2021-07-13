package io.summer.springbootwithjpa;

import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;

import javax.annotation.PostConstruct;
// import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.summer.model.Employee;
import io.summer.model.EmployeeType;

@SpringBootApplication
@EntityScan(basePackages = "io.summer")
@EnableTransactionManagement
public class SpringBootWithJpaApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithJpaApplication.class, args);
	}
	
	@Autowired
	EmployeeRepository employeeRepository;

	@PostConstruct
	public void start() 
	{
		Employee employee = new Employee("James","3456789012",new Date(),EmployeeType.INTERN);
		employeeRepository.save(employee);

		Optional<Employee> e = employeeRepository.findById(2);
		if(e.isPresent())
			System.out.println(e);
		else
			System.out.println("NOT Available");


		Optional<Employee> e2 = employeeRepository.findById(1);
		if(e2.isPresent()){
			updateEmployee(e2.get());
		}

		Optional<Employee> e3 = employeeRepository.findById(4);
		if(e2.isPresent()){
			updateEmployeeAndAccessCard(e2.get());
		}
	}

	@Transactional
	private void updateEmployeeAndAccessCard(Employee e) {
		updateEmployee(e);
		// accesscardRepository.save(accessCard);
	}

		/*	Transaction Propagation :

			Propagation.REQUIRED (by Default) :
				
				Spring checks if there is an active transaction, and if nothing exists, it creates a new one. Otherwise,  appends to the currently active transaction

			Propagation.REQUIRES_NEW :

				Even if it's part of transaction it will create new transaction

			Propagation.MANDATORY :

				If there is an active transaction, then it will be used. If there isn't an active transaction, then Spring throws an exception (it won't create new transaction)

			Propagation.NEVER :

				Spring throws an exception if there's an active transaction:

			Propagation.NOT_SUPPORTED :

				If a current transaction exists, first Spring suspends it, and then the business logic is executed without a transaction:

			Propagation.SUPPORTS :

				Spring first checks if an active transaction exists. If a transaction exists, then the existing transaction will be used. If there isn't a transaction, it is executed non-transactional

		*/

	// Transactional property for both JPA as well as Spring
	@Transactional( propagation = Propagation.NOT_SUPPORTED,
		rollbackFor = SQLException.class, noRollbackFor = ArithmeticException.class)
	private void updateEmployee(Employee e) {

		// Get Transaction
		// Start Transaction
		e.setLastUpdateAt(new Date());
		employeeRepository.save(e);
		// End Transaction
		// Handle Rollback
	}
	/* 

		* Transaction -
				
			A database transaction is a sequence of actions that are treated as a single unit of work. These actions should either complete entirely or take no effect at all.


		* Rollback -
				
			A rollback is the operation of restoring a database to a previous state by canceling a specific transaction or transaction set

			BY default, for any exception happens spring auto-rollbacks
	*/
}