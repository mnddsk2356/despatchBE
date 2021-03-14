package com.dispatch.application.repository;


import com.dispatch.application.entities.BidMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<BidMaster, Integer> {
}
