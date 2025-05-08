package com.example.hackaton20251.Company.infraestructure;


import com.example.hackaton20251.airequest.domain.ModelType;
import com.example.hackaton20251.CompanyRestriction.domain.CompanyRestriction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRestrictionRepository extends JpaRepository<CompanyRestriction, Long> {

    List<CompanyRestriction> findByCompanyId(Long companyId);

    List<CompanyRestriction> findByCompanyIdAndModelType(Long companyId, ModelType modelType);

    boolean existsByCompanyIdAndModelType(Long companyId, ModelType modelType);
}