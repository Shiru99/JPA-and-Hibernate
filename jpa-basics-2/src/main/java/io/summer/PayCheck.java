package io.summer;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PayCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date issueDate;
    private float amount;

    @ManyToOne 
    @JoinColumn(name = "paycheck_for", unique = false)   // Foreign key reference
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public PayCheck() {

    }

    public PayCheck(Date issueDate, float amount) {
        this.issueDate = issueDate;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "\nPayCheck [amount=" + amount + ", id=" + id + ", issueDate=" + issueDate + "]";
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}