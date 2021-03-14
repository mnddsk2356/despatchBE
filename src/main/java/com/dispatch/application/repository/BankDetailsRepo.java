package com.dispatch.application.repository;

import com.dispatch.application.entities.BankDetails;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface BankDetailsRepo extends CrudRepository<BankDetails, Integer> {

    @Transactional
    @Modifying
    @Query("Delete From BankDetails where id =:bankDetailsId")
    void removeBybankDetailsId(@Param("bankDetailsId") int bankDetailsId);
}
