package com.dispatch.application.service;

import com.dispatch.application.entities.Company;
import com.dispatch.application.entities.Entities;
import com.dispatch.application.model.Users;
import com.dispatch.application.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl  implements  CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company findByCompanyname(String company) {
        return companyRepository.findByCompanyName(company);
    }



    @Override
    public Company findByCompanyById(Long companyId) {
        return companyRepository.findByCompanyId(companyId);
    }

    @Override
    public Company findByCompanyLoginName(String companyLogin) {
        return companyRepository.findByCompanyLoginName(companyLogin);
    }

    @Override
    public Company findByCompanyLoginName(String companyLoginName, Entities entityType) {
        return companyRepository.findByCompanyLoginName(companyLoginName,entityType);
    }


    @Override
    public void save(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void removeById(Long id) {
        companyRepository.removeById(id);
    }

    @Override
    public Company findByEmail(String email) {
        return companyRepository.findByEmail(email);
    }
}
