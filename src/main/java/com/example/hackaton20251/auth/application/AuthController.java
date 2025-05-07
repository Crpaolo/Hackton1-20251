package com.example.hackaton20251.auth.application;

import com.example.hackaton20251.auth.domain.AuthService;
import com.example.hackaton20251.auth.dto.JwtAuthResponse;
import com.example.hackaton20251.auth.dto.LoginReq;
import com.example.hackaton20251.auth.dto.RegisterReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginReq req) {
        return ResponseEntity.ok(authService.login(req));
    }

    @PostMapping("/register")
    public ResponseEntity<JwtAuthResponse> register(@RequestBody RegisterReq req) {
        return ResponseEntity.ok(authService.register(req));
    }
    @PostMapping("/admin")
    public ResponseEntity<Object> crearAdmin(@RequestBody RegisterReq req) {
        authService.crearAdmin(req);
        return ResponseEntity.ok("admin creado");
    }
}