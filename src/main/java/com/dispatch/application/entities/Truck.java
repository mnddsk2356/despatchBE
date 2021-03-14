package com.dispatch.application.entities;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="Truck")
@Scope("session")
public class Truck implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;


    private int truckTypeId;

    public int getTruckTypeId() {
        return truckTypeId;
    }

    public void setTruckTypeId(int truckTypeId) {
        this.truckTypeId = truckTypeId;
    }

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Company getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(Company ownedBy) {
        this.ownedBy = ownedBy;
    }

    private String regNumber;

    private BigDecimal quantity;

    @OneToOne(cascade = CascadeType.MERGE)
    private Company ownedBy;
}
