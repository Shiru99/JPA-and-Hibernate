package io.summer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/*
    Entity - Entities in JPA are nothing but POJOs (Plain old Java object) representing data that can be persisted to the database. An entity represents a table stored in a database. Every instance of an entity represents a row in the table.

    In most cases, the name of the table in the database and the name of the entity will not be the same. If we do not use the @Table annotation, the name of the entity will be considered the name of the table.

    list of tables      :   # test=> \dt
    For table details   :   # test=> \d employee_data
    table entries       :   # test=> select * from employee_data

    <i>postgresql uses small-case database & table names</i>

*/

@Entity
@Table(name = "EMPLOYEE_DATA")
public class Employee {
  
    /*   @Id    -   primary key

        @GeneratedValue - property of database
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // default
    private int id;   

    private String name;

    @Column(name = "AadhaarNumber", unique = true, nullable = false, length = 12, updatable = false)
    private String ssn;     // Social Security number (for India - Aadhaar)

    // private int age;     // default int value - age = 0  & So nullable = false for int columns
    private Integer age; 
    // private BigInteger age;
    
    @Temporal(TemporalType.DATE)
    private Date DOB;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateAt;

    // Default behavior is ORDINAL  - will create mess on reordering EmployeeType
    // @Enumerated(EnumType.ORDINAL)
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    
    @Transient
    private String debugString; 
    // private transient String debugString;    // exclude from Database

    public Employee() {
    }

    public Employee(int id, String name, String ssn,int age, Date DOB, Date lastUpdateAt, EmployeeType employeeType) {
        // this.id = id;
        this.name = name;
        this.ssn = ssn;
        this.age = age;
        this.DOB = DOB;
        this.lastUpdateAt = lastUpdateAt;
        this.employeeType = employeeType;
    }

    public Employee(int id, String name, String ssn) {
        // this.id = id;
        this.name = name;
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "\n-----\n"+"Employee "+"\n\tDOB=" + DOB + ",\n\t age=" + age + ",\n\t debugString=" + debugString + ",\n\t employeeType=" + employeeType + ",\n\t id=" + id + ",\n\t lastUpdateAt=" + lastUpdateAt + ",\n\t name=" + name + ",\n\t ssn=" + ssn+"\n-----\n";
    }

    
}