package io.summer;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AccessCard {

    @Id
    @GeneratedValue
    private int id;
    private Date issuedDate;
    private boolean isActive;
    private String firmwareVersion;

    public AccessCard(Date issuedDate, boolean isActive,String firmwareVersion) {
        this.issuedDate = issuedDate;
        this.isActive = isActive;
        this.firmwareVersion = firmwareVersion;
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