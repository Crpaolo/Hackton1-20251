package com.example.hackaton20251.CompanyRestriction.infrastructure;

import com.example.hackaton20251.CompanyRestriction.domain.CompanyRestriction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRestrictionRepository extends JpaRepository<CompanyRestriction, Long> {
    List<CompanyRestriction> findByCompany_Id(Long companyId);
}