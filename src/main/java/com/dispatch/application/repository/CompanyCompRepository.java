package com.dispatch.application.repository;

import com.dispatch.application.entities.CompanyCompliance;
import com.dispatch.application.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CompanyCompRepository extends JpaRepository<CompanyCompliance, Integer> {

    @Transactional
    @Modifying
    @Query("Delete From CompanyCompliance where company.id =:compId")
    void removeBycompId(@Param("compId") Long compId);

}
