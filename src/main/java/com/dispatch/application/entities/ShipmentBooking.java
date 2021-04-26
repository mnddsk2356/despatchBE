package com.dispatch.application.entities;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="ShipmentBooking")
@Scope("session")
public class ShipmentBooking implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;

    @Column(unique = true)
    private String bookingNumber ;

    private String sourceLocation;

    private String destination;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    private String status;

    private String shipmentType;

    private int shipmentWeight;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverMob() {
        return driverMob;
    }

    public void setDriverMob(String driverMob) {
        this.driverMob = driverMob;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public Parking getParkingStatus() {
        return parking;
    }

    public void setParkingStatus(Parking parking) {
        this.parking = parking;
    }

    private String shipmentUnit;

    private String vehicleNumber;

    private Long driverId;

    private Long logisticOfficerId;

    public Long getFinanceExecutiveId() {
        return financeExecutiveId;
    }

    public void setFinanceExecutiveId(Long financeExecutiveId) {
        this.financeExecutiveId = financeExecutiveId;
    }

    private Long financeExecutiveId;

    public Long getBayManagerId() {
        return bayManagerId;
    }

    public void setBayManagerId(Long bayManagerId) {
        this.bayManagerId = bayManagerId;
    }

    private Long yardManagerId;

    private Long bayManagerId;

    public Long getYardManagerId() {
        return yardManagerId;
    }

    public void setYardManagerId(Long yardManagerId) {
        this.yardManagerId = yardManagerId;
    }

    public int getSourceBranchId() {
        return sourceBranchId;
    }

    public void setSourceBranchId(int sourceBranchId) {
        this.sourceBranchId = sourceBranchId;
    }

    public int getTargetBranchId() {
        return targetBranchId;
    }

    public void setTargetBranchId(int targetBranchId) {
        this.targetBranchId = targetBranchId;
    }
    public Date getRelaesedFromBayDateTime() {
        return relaesedFromBayDateTime;
    }

    public void setRelaesedFromBayDateTime(Date relaesedFromBayDateTime) {
        this.relaesedFromBayDateTime = relaesedFromBayDateTime;
    }
    private int sourceBranchId;

    private int targetBranchId;

    public String getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    private int companyId;

    private int rating;

    private String feedback;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getSource() {
        return sourceLocation;
    }

    public void setSource(String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getShipmentType() {
        return shipmentType;
    }

    public void setShipmentType(String shipmentType) {
        this.shipmentType = shipmentType;
    }

    public int getShipmentWeight() {
        return shipmentWeight;
    }

    public void setShipmentWeight(int shipmentWeight) {
        this.shipmentWeight = shipmentWeight;
    }

    public String getShipmentUnit() {
        return shipmentUnit;
    }

    public void setShipmentUnit(String shipmentUnit) {
        this.shipmentUnit = shipmentUnit;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getLogisticOfficerId() {
        return logisticOfficerId;
    }

    public void setLogisticOfficerId(Long logisticOfficerId) {
        this.logisticOfficerId = logisticOfficerId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Long getGateKeeperId() {
        return gateKeeperId;
    }

    public void setGateKeeperId(Long gateKeeperId) {
        this.gateKeeperId = gateKeeperId;
    }


    public boolean isDropRequired() {
        return dropRequired;
    }

    public void setDropRequired(boolean dropRequired) {
        this.dropRequired = dropRequired;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public BigDecimal getShipmentCost() {
        return shipmentCost;
    }

    public void setShipmentCost(BigDecimal shipmentCost) {
        this.shipmentCost = shipmentCost;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getBookingStartDate() {
        return bookingStartDate;
    }

    public void setBookingStartDate(Date bookingStartDate) {
        this.bookingStartDate = bookingStartDate;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    private Long gateKeeperId;

    private boolean dropRequired;

    private String dropLocation;

    private BigDecimal shipmentCost;

    private BigDecimal amountPaid;

    private String comment;



    private Date bookingStartDate;

    private Date deliveredDate;

    private String driverName;

    private String driverMob;

    private String truckType;

    private Date arrivalDateTime;

    private Date relaesedFromBayDateTime;

    @OneToOne(cascade = CascadeType.ALL)
    private Parking parking;

    @OneToOne(cascade = CascadeType.ALL)
    private Billing billing;

    @OneToOne(cascade = CascadeType.ALL)
    private Audit audit;


}
