package io.summer.springbootwithjpa;

import java.util.Date;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import io.summer.model.Employee;
import io.summer.model.EmployeeType;

@SpringBootApplication
@EntityScan(basePackages = "io.summer")
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

		Optional<Employee> e = employeeRepository.findById(1);
		if(e.isPresent())
			System.out.println(e);
		else
			System.out.println("NOT Available");

	}
}