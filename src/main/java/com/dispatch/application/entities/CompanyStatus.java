package com.dispatch.application.entities;


import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CompanyStatus")
@Scope("session")

public class CompanyStatus implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;

    @Column(unique = true)
    private String regNumber ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getAdhar() {
        return adhar;
    }

    public void setAdhar(String adhar) {
        this.adhar = adhar;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    private String pan;

    private String adhar;

    @OneToOne(cascade = CascadeType.ALL)
    private Audit audit;
}
