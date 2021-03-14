package com.dispatch.application.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="BidMaster")
@Scope("session")

public class BidMaster implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;

    private String shipFrom;

    private int shipFromZoneId;

    private int shipToZoneId;

    public int getShipFromZoneId() {
        return shipFromZoneId;
    }

    public void setShipFromZoneId(int shipFromZoneId) {
        this.shipFromZoneId = shipFromZoneId;
    }

    public int getShipToZoneId() {
        return shipToZoneId;
    }

    public void setShipToZoneId(int shipToZoneId) {
        this.shipToZoneId = shipToZoneId;
    }

    public int getTruckType() {
        return truckType;
    }

    public void setTruckType(int truckType) {
        this.truckType = truckType;
    }

    public int getTripAssigned() {
        return tripAssigned;
    }

    public void setTripAssigned(int tripAssigned) {
        this.tripAssigned = tripAssigned;
    }

    private int truckType;

    private int tripAssigned;

    private String shipTo;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private String comment;

    private Date bidStartDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShipFrom() {
        return shipFrom;
    }

    public void setShipFrom(String shipFrom) {
        this.shipFrom = shipFrom;
    }

    public String getShipTo() {
        return shipTo;
    }

    public void setShipTo(String shipTo) {
        this.shipTo = shipTo;
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


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(BigDecimal targetPrice) {
        this.targetPrice = targetPrice;
    }

    public Company getBidBy() {
        return bidBy;
    }

    public void setBidBy(Company bidBy) {
        this.bidBy = bidBy;
    }

    public List<Quote> getQuoteList() {
        return quoteList;
    }

    public void setQuoteList(List<Quote> quoteList) {
        this.quoteList = quoteList;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public Date getBidCloseDate() {
        return bidCloseDate;
    }

    public void setBidCloseDate(Date bidCloseDate) {
        this.bidCloseDate = bidCloseDate;
    }

    public Date getContractStDt() {
        return contractStDt;
    }

    public void setContractStDt(Date contractStDt) {
        this.contractStDt = contractStDt;
    }

    public Date getContrcatEndDt() {
        return contrcatEndDt;
    }

    public void setContrcatEndDt(Date contrcatEndDt) {
        this.contrcatEndDt = contrcatEndDt;
    }

    private Date bidEndDate;

    private Date bidCloseDate;

    private Date contractStDt;

    private Date contrcatEndDt;

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    private String status;

    private String dropLocation;

    public boolean isDropReq() {
        return isDropReq;
    }

    public void setDropReq(boolean dropReq) {
        isDropReq = dropReq;
    }

    @JsonProperty
    private boolean isDropReq;

    private BigDecimal targetPrice;

    @OneToOne(cascade = CascadeType.MERGE)
    private Company bidBy;

    @OneToMany(mappedBy = "bidMaster" ,fetch = FetchType.EAGER,cascade= CascadeType.ALL)
    @JsonManagedReference

    private List<Quote> quoteList;

    @OneToOne(cascade = CascadeType.ALL)
    private Audit audit;

    public BidMaster() {
    }

    public BidMaster(String status) {
        this.status = "";
    }

}
