package com.dispatch.application.model;

import java.math.BigDecimal;

public class NegotiateQuoteReq {

    private Long bidId;

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    public BigDecimal getNegotiatePrice() {
        return negotiatePrice;
    }

    public void setNegotiatePrice(BigDecimal negotiatePrice) {
        this.negotiatePrice = negotiatePrice;
    }

    private int quoteId;

    private BigDecimal negotiatePrice;
}
