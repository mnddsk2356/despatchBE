package com.dispatch.application.entities;

import com.dispatch.application.model.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="UserCompliance")
@Scope("session")

public class UserCompliance implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;

    private String documentName ;

    private String issuedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    private String city;

    private Date validFrom;

    private Date validTo;

    private String docNumber;

    private String comment;

    private String uploadPath;


    private boolean renewalRequired;

    public boolean isRenewalRequired() {
        return renewalRequired;
    }

    public void setRenewalRequired(boolean renewalRequired) {
        this.renewalRequired = renewalRequired;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
    @JoinColumn(name = "user_id")

    private Users user;


    @OneToOne(cascade = CascadeType.ALL)
    private Audit audit;


}

