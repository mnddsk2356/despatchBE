package com.dispatch.application.model;

import java.math.BigDecimal;

public class QuoteRequest {

    private Long bidFromId;

    private Long quoteById;

    public BigDecimal getNegotiatePrice() {
        return negotiatePrice;
    }

    public void setNegotiatePrice(BigDecimal negotiatePrice) {
        this.negotiatePrice = negotiatePrice;
    }

    private BigDecimal quotePrice;

    private BigDecimal negotiatePrice;

    private Long bidId;

    public Long getBidFromId() {
        return bidFromId;
    }

    public void setBidFromId(Long bidFromId) {
        this.bidFromId = bidFromId;
    }

    public Long getQuoteById() {
        return quoteById;
    }

    public void setQuoteById(Long quoteById) {
        this.quoteById = quoteById;
    }

    public BigDecimal getQuotePrice() {
        return quotePrice;
    }

    public void setQuotePrice(BigDecimal quotePrice) {
        this.quotePrice = quotePrice;
    }

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }





}
