package com.example.hackaton20251.Company.domain;

import com.example.hackaton20251.CompanyRestriction.domain.CompanyRestriction;
import com.example.hackaton20251.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
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

    @OneToOne
    @JoinColumn(name = "administrador_id")
    private User administrador;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<User> user = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<CompanyRestriction> restricciones = new ArrayList<>();


}

