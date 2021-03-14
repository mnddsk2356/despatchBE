package com.dispatch.application.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="Quote")
@Scope("session")
public class Quote implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", quotePrice=" + quotePrice +
                ", quoteBy=" + quoteById +
                '}';
    }

    private BigDecimal quotePrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Quote() {
    }

    public Quote(int id, BigDecimal quotePrice, Long quoteById) {
        this.id = id;
        this.quotePrice = quotePrice;
        this.quoteById = quoteById;
    }

    public BigDecimal getQuotePrice() {
        return quotePrice;
    }

    public void setQuotePrice(BigDecimal quotePrice) {
        this.quotePrice = quotePrice;
    }

    public BigDecimal getNegotiatePrice() {
        return negotiatePrice;
    }

    public void setNegotiatePrice(BigDecimal negotiatePrice) {
        this.negotiatePrice = negotiatePrice;
    }

    public String getQuoteStatus() {
        return quoteStatus;
    }

    public void setQuoteStatus(String quoteStatus) {
        this.quoteStatus = quoteStatus;
    }

    public BidMaster getBidMaster() {
        return bidMaster;
    }

    public void setBidMaster(BidMaster bidMaster) {
        this.bidMaster = bidMaster;
    }



    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    private BigDecimal negotiatePrice;

    private String quoteStatus;

    public int getTripAssigned() {
        return tripAssigned;
    }

    public void setTripAssigned(int tripAssigned) {
        this.tripAssigned = tripAssigned;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    private int tripAssigned;

    private String remark;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
    @JoinColumn(name = "bid_id")

    private BidMaster bidMaster;

    public Long getQuoteById() {
        return quoteById;
    }

    public void setQuoteById(Long quoteById) {
        this.quoteById = quoteById;
    }

    private Long quoteById;

    @OneToOne(cascade = CascadeType.ALL)
    private Audit audit;
}
