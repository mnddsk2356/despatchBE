package com.dispatch.application.service;

import com.dispatch.application.entities.Audit;
import com.dispatch.application.entities.BidMaster;
import com.dispatch.application.entities.Company;
import com.dispatch.application.model.BidRequest;
import com.dispatch.application.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BidServiceImpl implements  BidService {

    @Autowired
    BidRepository bidRepository;

    @Override
    public void createBid(BidRequest bidRequest) {

        BidMaster bidMaster = new BidMaster("");
        Company company = new Company();
        company.setId(bidRequest.getCompanyId());
        Audit audit = new Audit();
        audit.setAudit_event("Bid Created ");
        audit.setDate_created(new Date());
        audit.setTime_created(new Date());
        bidMaster.setAudit(audit);
        bidMaster.setBidCloseDate(bidRequest.getBidCloseDate());
        bidMaster.setBidEndDate(bidRequest.getBidEndDate());
        bidMaster.setBidStartDate(bidRequest.getBidStartDate());
        bidMaster.setContractStDt(bidRequest.getContractStDt());
        bidMaster.setContrcatEndDt(bidRequest.getContractEndDt());
        bidMaster.setShipFrom(bidRequest.getSourceLOcation());
        bidMaster.setShipTo(bidRequest.getTargetLocation());

        bidMaster.setTargetPrice(bidRequest.getTargetPrice());
        bidMaster.setShipFromZoneId(bidRequest.getSourceZoneId());
        bidMaster.setShipToZoneId(bidRequest.getTargetZoneId());
        bidMaster.setTripAssigned(bidRequest.getTripNumber());
        bidMaster.setTruckType(bidRequest.getTruckTypeId());
        bidMaster.setBidBy(company);

        bidRepository.save(bidMaster);



    }

    @Override
    public List<BidMaster> getBidList() {
        return bidRepository.findAll();
    }
}
