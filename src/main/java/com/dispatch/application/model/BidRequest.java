package com.dispatch.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class BidRequest {

    private Long companyId;

    private int quoteId;

    private Date bidStartDate;

    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    private Date bidEndDate;

    private Date contractStDt;

    private Date contractEndDt;

    public int getTruckTypeId() {
        return truckTypeId;
    }

    public void setTruckTypeId(int truckTypeId) {
        this.truckTypeId = truckTypeId;
    }

    private int truckTypeId;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getBidStartDate() {
        return bidStartDate;
    }

    public void setBidStartDate(Date bidStartDate) {
        this.bidStartDate = bidStartDate;
    }

    public Date getBidEndDate() {
        return bidEndDate;
    }

    public void setBidEndDate(Date bidEndDate) {
        this.bidEndDate = bidEndDate;
    }

    public Date getBidCloseDate() {
        return bidCloseDate;
    }

    public void setBidCloseDate(Date bidCloseDate) {
        this.bidCloseDate = bidCloseDate;
    }

    public String getSourceLOcation() {
        return sourceLOcation;
    }

    public void setSourceLOcation(String sourceLOcation) {
        this.sourceLOcation = sourceLOcation;
    }

    public String getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(String targetLocation) {
        this.targetLocation = targetLocation;
    }

    public boolean isDropReq() {
        return isDropReq;
    }

    public void setDropReq(boolean dropReq) {
        isDropReq = dropReq;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }




    public BigDecimal getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(BigDecimal targetPrice) {
        this.targetPrice = targetPrice;
    }

    public BigDecimal getNegotiatePrice() {
        return negotiatePrice;
    }

    public void setNegotiatePrice(BigDecimal negotiatePrice) {
        this.negotiatePrice = negotiatePrice;
    }

    private BigDecimal negotiatePrice;

    private Date bidCloseDate;

    private String sourceLOcation;

    private int sourceZoneId;

    public Date getContractStDt() {
        return contractStDt;
    }

    public void setContractStDt(Date contractStDt) {
        this.contractStDt = contractStDt;
    }

    public Date getContractEndDt() {
        return contractEndDt;
    }

    public void setContractEndDt(Date contrcatEndDt) {
        this.contractEndDt = contractEndDt;
    }

    private String targetLocation;

    private int targetZoneId;

    @JsonProperty
    private boolean isDropReq;

    public int getSourceZoneId() {
        return sourceZoneId;
    }

    public void setSourceZoneId(int sourceZoneId) {
        this.sourceZoneId = sourceZoneId;
    }

    public int getTargetZoneId() {
        return targetZoneId;
    }

    public void setTargetZoneId(int targetZoneId) {
        this.targetZoneId = targetZoneId;
    }

    public int getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
    }


    private int tripNumber;



    private String dropLocation;



    private BigDecimal targetPrice;


}
