package com.example.hackaton20251.RestriccionEmpresa.domain;

import com.example.hackaton20251.Empresa.domain.Empresa;
import com.example.hackaton20251.RestriccionEmpresa.infrastructure.RestriccionEmpresaRepository;
import com.example.hackaton20251.user.domain.User;
import com.example.hackaton20251.user.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestriccionEmpresaService {

    private final RestriccionEmpresaRepository restriccionRepository;
    private final UserRepository userRepository;

    public RestriccionEmpresa createRestriction(RestriccionEmpresa restriction, String email) {
        User admin = (User) userRepository.findByEmail(email).orElseThrow();
        Empresa empresa = admin.getEmpresa(); // Se asume que el admin tiene una empresa asociada.
        restriction.setEmpresa(empresa);
        return restriccionRepository.save(restriction);
    }

    public List<RestriccionEmpresa> getRestrictionsByAdmin(String email) {
        User admin = (User) userRepository.findByEmail(email).orElseThrow();
        return restriccionRepository.findByEmpresaId(admin.getEmpresa().getId());
    }

    public RestriccionEmpresa updateRestriction(Long id, RestriccionEmpresa newRestriction, String email) {
        User admin = (User) userRepository.findByEmail(email).orElseThrow();
        RestriccionEmpresa restriction = restriccionRepository.findById(id)
                .filter(r -> r.getEmpresa().getId().equals(admin.getEmpresa().getId()))
                .orElseThrow();

        restriction.setModelo(newRestriction.getModelo());
        restriction.setMaxSolicitudesPorDia(newRestriction.getMaxSolicitudesPorDia());
        restriction.setMaxTokensPorDia(newRestriction.getMaxTokensPorDia());
        return restriccionRepository.save(restriction);
    }

    public void deleteRestriction(Long id, String email) {
        User admin = (User) userRepository.findByEmail(email).orElseThrow();
        RestriccionEmpresa restriction = restriccionRepository.findById(id)
                .filter(r -> r.getEmpresa().getId().equals(admin.getEmpresa().getId()))
                .orElseThrow();
        restriccionRepository.delete(restriction);
    }
}