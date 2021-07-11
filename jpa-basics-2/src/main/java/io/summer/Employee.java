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


@Entity
@Table(name = "EMPLOYEE_DATA")
public class Employee {
  

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // default
    private int id;   

    private String name;

    @Column(name = "AadhaarNumber", unique = true, nullable = false, length = 12, updatable = false)
    private String ssn;     // Social Security number (for India - Aadhaar)

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateAt;

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    
    @Transient
    private String debugString; 

    public Employee() {
    }

    public Employee(String name, String ssn, Date lastUpdateAt, EmployeeType employeeType) {
        this.name = name;
        this.ssn = ssn;
        this.lastUpdateAt = lastUpdateAt;
        this.employeeType = employeeType;
    }

    public Employee(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "\n*******\n"+"Employee [employeeType=" + employeeType + ", id=" + id + ", lastUpdateAt=" + lastUpdateAt + ", name=" + name + ", ssn=" + ssn + "]"+"\n*******\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getLastUpdateAt() {
        return lastUpdateAt;
    }

    public void setLastUpdateAt(Date lastUpdateAt) {
        this.lastUpdateAt = lastUpdateAt;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public String getDebugString() {
        return debugString;
    }

    public void setDebugString(String debugString) {
        this.debugString = debugString;
    }

    
}