package com.example.hackaton20251.CompanyRestriction.domain;


import com.example.hackaton20251.CompanyRestriction.infrastructure.CompanyRestrictionRepository;
import org.springframework.stereotype.Service;

@Service
public class RestriccionService {
    private final CompanyRestrictionRepository companyRestrictionRepository;

    public RestriccionService(CompanyRestrictionRepository companyRestrictionRepository) {
        this.companyRestrictionRepository = companyRestrictionRepository;
    }



}
