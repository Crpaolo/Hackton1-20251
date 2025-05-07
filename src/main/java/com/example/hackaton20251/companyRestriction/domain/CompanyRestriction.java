package com.example.hackaton20251.companyRestriction.domain;

import com.example.hackaton20251.company.domain.Company;
import com.example.hackaton20251.user.domain.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "companies")
public class CompanyRestriction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String ruc;

    private LocalDate affiliationDate;

    private Boolean active;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<CompanyRestriction> restrictions;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<User> users;
}

