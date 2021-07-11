package io.summer;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PayCheck {

    @Id
    @GeneratedValue
    private int id;
    private Date issueDate;
    private float amount;
    
    public PayCheck(Date issueDate, float amount) {
        this.issueDate = issueDate;
        this.amount = amount;
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