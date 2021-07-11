package io.summer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

    /* 
        Default for 1-1 : fetch = FetchType.EAGER - fetches all referenced data
        Default for m-* : fetch = FetchType.LAZY - fetches referenced data on demand
    */
    @OneToOne                        
    // @OneToOne(fetch = FetchType.LAZY)
    private AccessCard card;

    public AccessCard getCard() {
        return card;
    }

    public void setCard(AccessCard card) {
        this.card = card;
    }

    @OneToMany(mappedBy = "employee")
    private List<PayCheck> payChecks = new ArrayList<PayCheck>();

    public List<PayCheck> getPayChecks() {
        return payChecks;
    }

    public void setPayChecks(PayCheck payCheck) {
        this.payChecks.add(payCheck);
    }

    /*
        Caution : FetchType.EAGER can be resource extensive (may cause chain reaction effect)
    */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "email_group_subscription",
        joinColumns = @JoinColumn(name="id_employee"),
        inverseJoinColumns = @JoinColumn(name = "subscription_group_id")
    )
    private List<EmailGroup> emailGroups = new ArrayList<EmailGroup>();

    public List<EmailGroup> getEmailGroups() {
        return emailGroups;
    }

    public void setEmailGroups(EmailGroup emailGroups) {
        this.emailGroups.add(emailGroups);
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
        return "\n*******\n"+"Employee :\n" + "employeeType=" + employeeType + ", id=" + id + ", lastUpdateAt=" + lastUpdateAt + ", name=" + name + ", ssn=" + ssn +"\nEmployee card :"+ card+"\n*******\n";
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