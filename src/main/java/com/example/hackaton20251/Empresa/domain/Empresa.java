package com.example.hackaton20251.Empresa.domain;

import com.example.hackaton20251.RestriccionEmpresa.domain.RestriccionEmpresa;
import com.example.hackaton20251.user.domain.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Empresa {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String ruc;
    private LocalDate fechaAfiliacion;
    private boolean activa;

    @OneToOne(cascade = CascadeType.ALL)
    private User administrador;

    @OneToMany(mappedBy = "empresa")
    private List<User> usuarios;

    @OneToMany(mappedBy = "empresa")
    private List<RestriccionEmpresa> restricciones;
}
