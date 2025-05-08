package com.example.hackaton20251.Empresa.infrastructure;

import com.example.hackaton20251.Empresa.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Optional<Empresa> findById(Long id);
    List<Empresa> findAll();
}
