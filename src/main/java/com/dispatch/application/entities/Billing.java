package com.dispatch.application.entities;


import com.dispatch.application.model.Users;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="Billing")
@Scope("session")
public class Billing implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;

    @OneToOne(cascade = CascadeType.ALL)
    private Users billingOfficer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getBillingOfficer() {
        return billingOfficer;
    }

    public void setBillingOfficer(Users billingOfficer) {
        this.billingOfficer = billingOfficer;
    }

    public Users getApprovalOfficer() {
        return approvalOfficer;
    }

    public void setApprovalOfficer(Users approvalOfficer) {
        this.approvalOfficer = approvalOfficer;
    }

    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(BigDecimal approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private  Users approvalOfficer;

    private BigDecimal approvedAmount;

    private Date billingDate;

    @Column(unique = true)
    private String invoiceId ;


}
