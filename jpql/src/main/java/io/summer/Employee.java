package io.summer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMPLOYEE_DATA")
@NamedQuery(query = "SELECT e FROM Employee e  WHERE e.name LIKE 'J%'",name = "query1")
@NamedQuery(query = "SELECT e from Employee e WHERE e.card.isActive = :status",name = "query2")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // default
    private int id;

    private String name;

    @Column(name = "AadhaarNumber", unique = true, nullable = false, length = 12, updatable = false)
    private String ssn; // Social Security number (for India - Aadhaar)

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateAt;

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    @OneToOne
    private AccessCard card;

    public AccessCard getCard() {
        return card;
    }

    public void setCard(AccessCard card) {
        this.card = card;
    }

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
        return "\n*******\n"+"Employee :\n" + "employeeType=" + employeeType + ", id=" + id + ", lastUpdateAt=" + lastUpdateAt + ", name=" + name + ", ssn=" + ssn +"\nEmployee card :"+ card +"\n*******\n";
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
}