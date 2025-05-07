package com.example.hackaton20251.auth.domain;


import com.example.hackaton20251.auth.dto.JwtAuthResponse;
import com.example.hackaton20251.auth.dto.LoginReq;
import com.example.hackaton20251.auth.dto.RegisterReq;
import com.example.hackaton20251.config.JwtService;
import com.example.hackaton20251.exceptions.UserAlreadyExistException;
import com.example.hackaton20251.user.domain.Role;
import com.example.hackaton20251.user.domain.User;
import com.example.hackaton20251.user.infrastructure.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    private final UserRepository<User> userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthService(UserRepository<User> userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = new ModelMapper();
    }
    public JwtAuthResponse login(LoginReq req) {
        Optional<User> user;
        user = userRepository.findByEmail(req.getEmail());

        if (user.isEmpty()) throw new UsernameNotFoundException("Email is not registered");

        if (!passwordEncoder.matches(req.getPassword(), user.get().getPassword()))
            throw new IllegalArgumentException("Password is incorrect");

        JwtAuthResponse response = new JwtAuthResponse();

        response.setToken(jwtService.generateToken(user.get()));
        return response;
    }
    public JwtAuthResponse register(RegisterReq req){
        Optional<User> user = userRepository.findByEmail(req.getEmail());
        if (user.isPresent()) throw new UserAlreadyExistException("Email is already registered");
        User user1 = modelMapper.map(req, User.class);
        user1.setPassword(passwordEncoder.encode(req.getPassword()));
        user1.setRole(Role.ROLE_USER);
        user1.setFechaDeRegistro(LocalDate.now());
        userRepository.save(user1);
        JwtAuthResponse response = new JwtAuthResponse();
        response.setToken(jwtService.generateToken(user1));

        //evento
        //eventPublisher.publishEvent(new HelloEmailEvent(user1.getEmail()));

        return response;
    }
    public void crearAdmin(RegisterReq req){

        Optional<User> user = userRepository.findByEmail(req.getEmail());
        if (user.isPresent()) throw new UserAlreadyExistException("Email is already registered");
        User user1 = modelMapper.map(req, User.class);
        user1.setPassword(passwordEncoder.encode(req.getPassword()));
        user1.setRole(Role.ADMIN);

        user1.setFechaDeRegistro(LocalDate.now());
        userRepository.save(user1);
    }



}
