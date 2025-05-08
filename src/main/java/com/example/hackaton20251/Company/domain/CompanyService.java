package com.example.hackaton20251.Company.domain;

import com.example.hackaton20251.Company.dtos.CompanyRequest;
import com.example.hackaton20251.Company.dtos.CompanyResponse;
import com.example.hackaton20251.Company.infraestructure.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    private CompanyResponse toResponse(Company empresa) {
        CompanyResponse res = new CompanyResponse();
        res.id = empresa.getId();
        res.name = empresa.getName();
        res.ruc = empresa.getRuc();
        res.activa = empresa.isActiva();
        return res;
    }


    public CompanyResponse crearEmpresa(CompanyRequest request) {
        Company empresa = new Company();
        empresa.setName(request.name);
        empresa.setRuc(request.ruc);
        empresa.setActiva(true);
        empresa = companyRepository.save(empresa);

        return toResponse(empresa);
    }

    public List<CompanyResponse> listarEmpresas() {
        return companyRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }



    public CompanyResponse obtenerEmpresa(Long id) {
        Company empresa = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        return toResponse(empresa);
    }

    public CompanyResponse actualizarEmpresa(Long id, CompanyRequest request) {
        Company empresa = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));

        empresa.setName(request.name);
        empresa.setRuc(request.ruc);

        return toResponse(companyRepository.save(empresa));
    }

    public void cambiarEstado(Long id, boolean activa) {
        Company empresa = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        empresa.setActiva(activa);
        companyRepository.save(empresa);
    }

}