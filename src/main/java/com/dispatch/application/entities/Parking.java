package com.dispatch.application.entities;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Parking")
@Scope("session")
public class Parking implements Serializable {



    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;

    private String parkingStatus;

    private Date truckArrivalDateTime;

    private Date gateEntryDateTime;

    private Date  parkingLotEntryDateTime;

    private Date bayEntryDateTime;

    private Long gateKeeperId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParkingStatus() {
        return parkingStatus;
    }

    public void setParkingStatus(String parkingStatus) {
        this.parkingStatus = parkingStatus;
    }

    public Date getTruckArrivalDateTime() {
        return truckArrivalDateTime;
    }

    public void setTruckArrivalDateTime(Date truckArrivalDateTime) {
        this.truckArrivalDateTime = truckArrivalDateTime;
    }

    public Date getGateEntryDateTime() {
        return gateEntryDateTime;
    }

    public void setGateEntryDateTime(Date gateEntryDateTime) {
        this.gateEntryDateTime = gateEntryDateTime;
    }

    public Date getParkingLotEntryDateTime() {
        return parkingLotEntryDateTime;
    }

    public void setParkingLotEntryDateTime(Date parkingLotEntryDateTime) {
        this.parkingLotEntryDateTime = parkingLotEntryDateTime;
    }

    public Date getBayEntryDateTime() {
        return bayEntryDateTime;
    }

    public void setBayEntryDateTime(Date bayEntryDateTime) {
        this.bayEntryDateTime = bayEntryDateTime;
    }

    public Long getGateKeeperId() {
        return gateKeeperId;
    }

    public void setGateKeeperId(Long gateKeeperId) {
        this.gateKeeperId = gateKeeperId;
    }

    public Long getYardBoyId() {
        return yardBoyId;
    }

    public void setYardBoyId(Long yardBoyId) {
        this.yardBoyId = yardBoyId;
    }

    public Long getBayManagerId() {
        return bayManagerId;
    }

    public void setBayManagerId(Long bayManagerId) {
        this.bayManagerId = bayManagerId;
    }

    public int getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(int parkingLot) {
        this.parkingLot = parkingLot;
    }

    public int getBayNumber() {
        return bayNumber;
    }

    public void setBayNumber(int bayNumber) {
        this.bayNumber = bayNumber;
    }

    private Long yardBoyId;

    private Long bayManagerId;

    private int parkingLot;

    private int bayNumber;







}
