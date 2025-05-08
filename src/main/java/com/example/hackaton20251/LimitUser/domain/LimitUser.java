package com.example.hackaton20251.LimitUser.domain;

import com.example.hackaton20251.CompanyRestriction.domain.CompanyRestriction;
import com.example.hackaton20251.user.domain.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Entity
@Data
@Getter
@Setter
public class LimitUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private int maxSolicitudes;
    private int maxTokens;
    private Duration ventanaTiempo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "restriccion_empresa_id")
    private CompanyRestriction restriccionBase;
}
