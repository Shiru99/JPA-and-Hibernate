package io.summer;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AccessCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date issuedDate;
    private boolean isActive;
    private String firmwareVersion;

    @OneToOne(mappedBy = "card")    
    private Employee owner;
    

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    public AccessCard(){
        
    }

    public AccessCard(Date issuedDate, boolean isActive,String firmwareVersion) {
        this.issuedDate = issuedDate;
        this.isActive = isActive;
        this.firmwareVersion = firmwareVersion;
    }

    @Override
    public String toString() {
        return "\n\t*******\n"+"\tAccessCard [firmwareVersion=" + firmwareVersion + ", id=" + id + ", isActive=" + isActive + ", issuedDate=" + issuedDate + "]"+"\n\t*******\n";
    }

    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public Date getIssuedDate() {
        return issuedDate;
    }
    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }
    public String getFirmwareVersion() {
        return firmwareVersion;
    }
    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }
}