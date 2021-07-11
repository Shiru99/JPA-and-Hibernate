package io.summer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class EmailGroup {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    /*
        mappedBy -> avoid creating multiple mapping tables 
                    (employee_data_emailgroup & emailgroup_employee_data)

        only employee_data_emailgroup will be created
    */
    @ManyToMany(mappedBy = "emailGroups") 
    private List<Employee> employee = new ArrayList<Employee>();

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee.add(employee);
    }

    public EmailGroup() {
    }

    public EmailGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EmailGroup [id=" + id + ", name=" + name + "]";
    }

}
