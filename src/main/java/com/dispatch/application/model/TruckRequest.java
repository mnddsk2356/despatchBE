package com.dispatch.application.model;

public class TruckRequest {

    private Long companyId;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public int getTruckTypeId() {
        return truckTypeId;
    }

    public void setTruckTypeId(int truckTypeId) {
        this.truckTypeId = truckTypeId;
    }

    public String getTruckRegNumber() {
        return truckRegNumber;
    }

    public void setTruckRegNumber(String truckRegNumber) {
        this.truckRegNumber = truckRegNumber;
    }

    private int truckTypeId;

    private String truckRegNumber;


}
