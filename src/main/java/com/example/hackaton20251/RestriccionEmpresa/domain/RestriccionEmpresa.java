package com.example.hackaton20251.RestriccionEmpresa.domain;

import com.example.hackaton20251.Empresa.domain.Empresa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class RestriccionEmpresa {
    @Id
    @GeneratedValue
    private Long id;

    private String modelo;
    private int maxSolicitudesPorDia;
    private int maxTokensPorDia;

    @ManyToOne
    private Empresa empresa;
}
