package com.dispatch.application.repository;



import com.dispatch.application.entities.Company;
import com.dispatch.application.entities.Entities;
import com.dispatch.application.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findByCompanyName(String companyName);
    @Query("FROM Company where email=?1")
    Company findByEmail(String email);
    @Query("FROM Company where companyLoginName=?1")
    Company findByCompLogin(String compLoginName);
    @Query(value = "FROM Company where companyLoginName=:companyLoginName and type=:entityType")
    Company findByCompanyLoginName(@Param("companyLoginName")  String companyLoginName , @Param("entityType") Entities entityType);

    @Query("FROM Company where companyLoginName=:compLogin")
    Company findByCompanyLoginName(@Param("compLogin") String compLogin);
    @Query("FROM Company where id=:compId")
    Company findByCompanyId(@Param("compId") Long compId);
    @Transactional
    @Modifying
    @Query("Delete From Company where id =:compId")
    void removeById(@Param("compId") Long compId);

}

