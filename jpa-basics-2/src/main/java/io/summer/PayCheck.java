package io.summer;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PayCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date issueDate;
    private float amount;

    public PayCheck() {

    }

    public PayCheck(Date issueDate, float amount) {
        this.issueDate = issueDate;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PayCheck [amount=" + amount + ", id=" + id + ", issueDate=" + issueDate + "]";
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