package com.example.hackaton20251.Company.domain;

import com.example.hackaton20251.CompanyRestriction.domain.CompanyRestriction;
import com.example.hackaton20251.user.domain.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String ruc;

    @Column(name = "affiliation_date")
    private LocalDate affiliationDate;

    private Boolean active;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<CompanyRestriction> restrictions;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<User> users;

}

