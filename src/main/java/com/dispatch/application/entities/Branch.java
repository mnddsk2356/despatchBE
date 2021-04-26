package com.dispatch.application.entities;

import com.dispatch.application.model.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Branch")
@Scope("session")
public class Branch  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String branchName;

    private String pincode;

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    private String branchAddress;

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    private int zoneId;

    public boolean isHeadOffice() {
        return isHeadOffice;
    }

    public void setHeadOffice(boolean headOffice) {
        isHeadOffice = headOffice;
    }

    @JsonProperty
    private boolean isHeadOffice;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Users> getStaffList() {
        return staffList;
    }

    public void setStaffList(Set<Users> staffList) {
        this.staffList = staffList;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
    @JoinColumn(name = "company_id")


    private Company company;


    @OneToMany(mappedBy = "branch" ,fetch = FetchType.EAGER,cascade= CascadeType.ALL)
    @JsonManagedReference

    private Set<Users> staffList;

   // private Company company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    private String branchLocation;

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Parking parking;

}
