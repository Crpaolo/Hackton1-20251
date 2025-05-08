package com.example.hackaton20251.RestriccionEmpresa.infrastructure;

import com.example.hackaton20251.RestriccionEmpresa.domain.RestriccionEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestriccionEmpresaRepository extends JpaRepository<RestriccionEmpresa, Long> {
    List<RestriccionEmpresa> findByEmpresaId(Long empresaId);
}