package com.example.hackaton20251.Empresa.application;

import com.example.hackaton20251.Empresa.domain.Empresa;
import com.example.hackaton20251.Empresa.domain.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/companies")
@PreAuthorize("hasRole('ROLE_SPARKY_ADMIN')")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> crearEmpresa(@RequestBody Empresa empresa) {
        Empresa empresaCreada = empresaService.crearEmpresa(empresa);
        return new ResponseEntity<>(empresaCreada, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Empresa> obtenerTodasLasEmpresas() {
        return empresaService.obtenerTodasLasEmpresas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obtenerEmpresaPorId(@PathVariable Long id) {
        Empresa empresa = empresaService.obtenerEmpresaPorId(id);
        return new ResponseEntity<>(empresa, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        Empresa empresaActualizada = empresaService.actualizarEmpresa(id, empresa);
        return new ResponseEntity<>(empresaActualizada, HttpStatus.OK);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Empresa> cambiarEstadoEmpresa(@PathVariable Long id, @RequestParam boolean estado) {
        Empresa empresaActualizada = empresaService.cambiarEstadoEmpresa(id, estado);
        return new ResponseEntity<>(empresaActualizada, HttpStatus.OK);
    }

    @GetMapping("/{id}/consumption")
    public ResponseEntity<String> obtenerReporteDeConsumo(@PathVariable Long id) {
        return ResponseEntity.ok("Reporte de consumo para la empresa con ID: " + id);
    }
}
