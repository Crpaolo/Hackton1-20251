package com.example.hackaton20251.Company.application;

import com.example.hackaton20251.Company.domain.CompanyService;
import com.example.hackaton20251.Company.dtos.CompanyRequest;
import com.example.hackaton20251.Company.dtos.CompanyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public CompanyResponse crear(@RequestBody CompanyRequest request) {
        CompanyResponse response = companyService.crearEmpresa(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response).getBody();
    }

    @GetMapping
    public List<CompanyResponse> listar() {
        return companyService.listarEmpresas();
    }

    @GetMapping("/{id}")
    public CompanyResponse obtener(@PathVariable Long id) {
        return companyService.obtenerEmpresa(id);
    }

    @PutMapping("/{id}")
    public CompanyResponse actualizar(@PathVariable Long id, @RequestBody CompanyRequest request) {
        return companyService.actualizarEmpresa(id, request);
    }

    @PatchMapping("/{id}/status")
    public void cambiarEstado(@PathVariable Long id, @RequestParam boolean activa) {
        companyService.cambiarEstado(id, activa);
    }

}