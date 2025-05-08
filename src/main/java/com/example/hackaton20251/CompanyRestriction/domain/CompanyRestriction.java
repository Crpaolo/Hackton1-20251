package com.example.hackaton20251.CompanyRestriction.domain;

import com.example.hackaton20251.Company.domain.Company;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Entity
@Data
@Getter
@Setter
public class CompanyRestriction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private int maxSolicitudes;
    private int maxTokens;
    private Duration ventanaTiempo;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

}
