package com.dispatch.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BranchRequest {

    private Long compId;

    private String branchName;

    private String location;

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public boolean isHeadOff() {
        return isHeadOff;
    }

    public void setHeadOff(boolean headOff) {
        isHeadOff = headOff;
    }

    private String address;

    private int zoneId;

    private String pincode;

    @JsonProperty
    private boolean isHeadOff;
}
