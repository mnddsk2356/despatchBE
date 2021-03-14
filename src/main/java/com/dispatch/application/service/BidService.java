package com.dispatch.application.service;

import com.dispatch.application.entities.BidMaster;
import com.dispatch.application.model.BidRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BidService {

     void createBid(BidRequest bidRequest);

     List<BidMaster> getBidList();

}
