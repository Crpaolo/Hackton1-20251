package com.example.hackaton20251.CompanyRestriction.domain;

import com.example.hackaton20251.airequest.domain.ModelType;
import com.example.hackaton20251.Company.domain.Company;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "company_restrictions")
public class CompanyRestriction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ModelType modelType;

    @Column(nullable = false)
    private Integer usageLimit;

    @Column(nullable = false)
    private String limitType; // TOKENS or REQUESTS

    private String window; // e.g., \"24h\"
}

