package com.example.hackaton20251.RestriccionEmpresa.application;

import com.example.hackaton20251.RestriccionEmpresa.domain.RestriccionEmpresa;
import com.example.hackaton20251.RestriccionEmpresa.domain.RestriccionEmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company/restrictions")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_COMPANY_ADMIN')")
public class RestriccionEmpresaController {

    private final RestriccionEmpresaService restriccionService;

    @PostMapping
    public ResponseEntity<RestriccionEmpresa> create(@RequestBody RestriccionEmpresa restriction, @AuthenticationPrincipal UserDetails user) {
        return ResponseEntity.ok(restriccionService.createRestriction(restriction, user.getUsername()));
    }

    @GetMapping
    public ResponseEntity<List<RestriccionEmpresa>> getAll(@AuthenticationPrincipal UserDetails user) {
        return ResponseEntity.ok(restriccionService.getRestrictionsByAdmin(user.getUsername()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestriccionEmpresa> update(@PathVariable Long id, @RequestBody RestriccionEmpresa restriction, @AuthenticationPrincipal UserDetails user) {
        return ResponseEntity.ok(restriccionService.updateRestriction(id, restriction, user.getUsername()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, @AuthenticationPrincipal UserDetails user) {
        restriccionService.deleteRestriction(id, user.getUsername());
        return ResponseEntity.noContent().build();
    }
}