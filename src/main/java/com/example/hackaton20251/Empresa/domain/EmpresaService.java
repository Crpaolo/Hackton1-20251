package com.example.hackaton20251.Empresa.domain;

import com.example.hackaton20251.Empresa.infrastructure.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    // Crear una nueva empresa
    public Empresa crearEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    // Obtener todas las empresas
    public List<Empresa> obtenerTodasLasEmpresas() {
        return empresaRepository.findAll();
    }

    // Obtener una empresa por ID
    public Empresa obtenerEmpresaPorId(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada con id: " + id));
    }

    // Actualizar una empresa
    public Empresa actualizarEmpresa(Long id, Empresa nuevaEmpresa) {
        Empresa empresaExistente = obtenerEmpresaPorId(id);
        empresaExistente.setNombre(nuevaEmpresa.getNombre());
        empresaExistente.setRuc(nuevaEmpresa.getRuc());
        empresaExistente.setFechaAfiliacion(nuevaEmpresa.getFechaAfiliacion());
        empresaExistente.setActiva(nuevaEmpresa.isActiva());
        return empresaRepository.save(empresaExistente);
    }

    // Cambiar el estado de una empresa (activar/desactivar)
    public Empresa cambiarEstadoEmpresa(Long id, boolean estado) {
        Empresa empresaExistente = obtenerEmpresaPorId(id);
        empresaExistente.setActiva(estado);
        return empresaRepository.save(empresaExistente);
    }
}
