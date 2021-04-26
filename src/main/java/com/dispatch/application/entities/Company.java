package com.dispatch.application.entities;


import com.dispatch.application.model.Users;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Company")
@Scope("session")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id ;

    @Column(unique = true)
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLoginName() {
        return companyLoginName;
    }

    public void setCompanyLoginName(String companyLoginName) {
        this.companyLoginName = companyLoginName;
    }

    @NotBlank
    @Size(max = 8)
    @Column(unique = true)
    private String companyLoginName;

    private String authPerson;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Branch> getBranch() {
        return branch;
    }

    public void setBranch(Set<Branch> branch) {
        this.branch = branch;
    }

    @Size(max = 10)
   private String mobile;

    @NotBlank
    @Size(max = 50)
    @Email
   private String email;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank

    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getAuthPerson() {
        return authPerson;
    }

    public void setAuthPerson(String authPerson) {
        this.authPerson = authPerson;
    }

    public String getCompAddress() {
        return compAddress;
    }

    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress;
    }

    public String getCompQualification() {
        return compQualification;
    }

    public void setCompQualification(String compQualification) {
        this.compQualification = compQualification;
    }

    public String getBusinessFrom() {
        return businessFrom;
    }

    public void setBusinessFrom(String businessFrom) {
        this.businessFrom = businessFrom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<CompanyCompliance> getCompanyComplianceList() {
        return companyComplianceList;
    }

    public void setCompanyComplianceList(Set<CompanyCompliance> companyComplianceList) {
        this.companyComplianceList = companyComplianceList;
    }



    public BankDetails getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankDetails bankDetails) {
        this.bankDetails = bankDetails;
    }

    public CompanyStatus getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(CompanyStatus companyStatus) {
        this.companyStatus = companyStatus;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public Entities getType() {
        return type;
    }

    public void setType(Entities type) {
        this.type = type;
    }

    private String compAddress;

    private String compQualification;

    private String businessFrom;

    private String status;


    @OneToMany(mappedBy = "company" ,fetch = FetchType.EAGER,cascade= CascadeType.ALL)
    @JsonManagedReference

    private Set<CompanyCompliance> companyComplianceList;



    @OneToMany(mappedBy = "company" ,fetch = FetchType.EAGER,cascade= CascadeType.ALL)
    @JsonManagedReference

    private Set<Branch> branch;

    @OneToMany(mappedBy = "ownerCompany" ,fetch = FetchType.EAGER,cascade= CascadeType.ALL)
    @JsonManagedReference

    private Set<Truck> truckSet;

    public Set<Truck> getTruckSet() {
        return truckSet;
    }

    public void setTruckSet(Set<Truck> truckSet) {
        this.truckSet = truckSet;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }

    @OneToOne(cascade = CascadeType.MERGE)
    private Agreement agreement;

    public Owner getOwnerDetails() {
        return ownerDetails;
    }

    public void setOwnerDetails(Owner ownerDetails) {
        this.ownerDetails = ownerDetails;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Owner ownerDetails;

    @OneToOne(cascade = CascadeType.ALL)
    private BankDetails bankDetails;

    @OneToOne(cascade = CascadeType.ALL)
    private CompanyStatus companyStatus;

    @OneToOne(cascade = CascadeType.ALL)
    private Audit audit;

    @OneToOne(cascade = CascadeType.MERGE)
    private Entities type;
}
