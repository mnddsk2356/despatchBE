package com.dispatch.application.entities;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="ParkingStatus")
@Scope("session")
public class ParkingStatus implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;

    private Date parkingEntryDate;

    private Date parkingExitDate;

    private Date bayEntryDate;

    private Date bayExitDate;

    private int parking;
    private int bayNumber;

    public int getTotalParkingSlots() {
        return totalParkingSlots;
    }

    public void setTotalParkingSlots(int totalParkingSlots) {
        this.totalParkingSlots = totalParkingSlots;
    }

    public int getAvailableParkingSlots() {
        return availableParkingSlots;
    }

    public void setAvailableParkingSlots(int availableParkingSlots) {
        this.availableParkingSlots = availableParkingSlots;
    }

    public int getTotalBaySlots() {
        return totalBaySlots;
    }

    public void setTotalBaySlots(int totalBaySlots) {
        this.totalBaySlots = totalBaySlots;
    }

    public int getAvailableBaySlots() {
        return availableBaySlots;
    }

    public void setAvailableBaySlots(int availableBaySlots) {
        this.availableBaySlots = availableBaySlots;
    }

    private int totalParkingSlots;
    private int availableParkingSlots;

    private int totalBaySlots;
    private int availableBaySlots;

    private long bookingIdInBay;

    public Date getBayEntryDate() {
        return bayEntryDate;
    }

    public void setBayEntryDate(Date bayEntryDate) {
        this.bayEntryDate = bayEntryDate;
    }

    public Date getBayExitDate() {
        return bayExitDate;
    }

    public void setBayExitDate(Date bayExitDate) {
        this.bayExitDate = bayExitDate;
    }

    public int getBayNumber() {
        return bayNumber;
    }

    public void setBayNumber(int bayNumber) {
        this.bayNumber = bayNumber;
    }

    public Long getBayUserId() {
        return bayUserId;
    }

    public void setBayUserId(Long bayUserId) {
        this.bayUserId = bayUserId;
    }

    public boolean isBayStatus() {
        return bayStatus;
    }

    public void setBayStatus(boolean bayStatus) {
        this.bayStatus = bayStatus;
    }

    public String getLoadUnloadStatus() {
        return loadUnloadStatus;
    }

    public void setLoadUnloadStatus(String loadUnloadStatus) {
        this.loadUnloadStatus = loadUnloadStatus;
    }

    private Long bayUserId;

    private boolean bayStatus;

    private String loadUnloadStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getParkingEntryDate() {
        return parkingEntryDate;
    }

    public void setParkingEntryDate(Date parkingEntryDate) {
        this.parkingEntryDate = parkingEntryDate;
    }

    public Date getParkingExitDate() {
        return parkingExitDate;
    }

    public void setParkingExitDate(Date parkingExitDate) {
        this.parkingExitDate = parkingExitDate;
    }

    public int getParking() {
        return parking;
    }

    public long getBookingIdInBay() {
        return bookingIdInBay;
    }

    public void setBookingIdInBay(long bookingIdInBay) {
        this.bookingIdInBay = bookingIdInBay;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getYardUserId() {
        return yardUserId;
    }

    public void setYardUserId(Long yardUserId) {
        this.yardUserId = yardUserId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    private long bookingId;

    private Long yardUserId;

    private boolean available;

    private String vehicleNumber;



}
