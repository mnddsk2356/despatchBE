package com.dispatch.application.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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

    public int getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(int totalSpace) {
        this.totalSpace = totalSpace;
    }

    private Date  parkingLotEntryDateTime;

    private Date bayEntryDateTime;

    private Long gateKeeperId;

    private int totalSpace;

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



    public int getBayNumber() {
        return bayNumber;
    }

    public void setBayNumber(int bayNumber) {
        this.bayNumber = bayNumber;
    }

    private Long yardBoyId;

    private Long bayManagerId;



    private int bayNumber;


    public Set<ParkingLotMap> getParkingLotMapSet() {
        return parkingLotMapSet;
    }

    public void setParkingLotMapSet(Set<ParkingLotMap> parkingLotMapSet) {
        this.parkingLotMapSet = parkingLotMapSet;
    }

    @OneToMany(mappedBy = "parking" ,fetch = FetchType.EAGER,cascade= CascadeType.ALL)
    @JsonManagedReference

    private Set<ParkingLotMap> parkingLotMapSet;




}
