package io.summer.springbootwithjpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.summer.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
            // <ClassName, Primary-Key Type>
}
