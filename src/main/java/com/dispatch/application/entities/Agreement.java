package com.dispatch.application.entities;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Agreement")
@Scope("session")
public class Agreement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String agreementId;

    private Date agreementStDt;

    private Date agreementEndDt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public Date getAgreementStDt() {
        return agreementStDt;
    }

    public void setAgreementStDt(Date agreementStDt) {
        this.agreementStDt = agreementStDt;
    }

    public Date getAgreementEndDt() {
        return agreementEndDt;
    }

    public void setAgreementEndDt(Date agreementEndDt) {
        this.agreementEndDt = agreementEndDt;
    }

    public int getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
    }

    public int getIssuingOfficerId() {
        return issuingOfficerId;
    }

    public void setIssuingOfficerId(int issuingOfficerId) {
        this.issuingOfficerId = issuingOfficerId;
    }

    private int tripNumber;

    private int issuingOfficerId;


}
