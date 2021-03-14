package com.dispatch.application.service;

import com.dispatch.application.entities.Company;
import com.dispatch.application.entities.Entities;
import org.springframework.stereotype.Service;


@Service
public interface CompanyService {

    Company findByCompanyname(String company);


    Company findByCompanyById(Long companyId);

     Company findByCompanyLoginName(String companyLogin);

    Company findByCompanyLoginName(String companyLoginName , Entities entityType);

    void save(Company company);
    void removeById(Long id);

    public Company findByEmail(String email);
}
