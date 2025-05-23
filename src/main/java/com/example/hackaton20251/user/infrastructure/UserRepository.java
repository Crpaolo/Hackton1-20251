package com.example.hackaton20251.user.infrastructure;

import com.example.hackaton20251.user.domain.Role;
import com.example.hackaton20251.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository<T extends User> extends JpaRepository<T, Integer> {
    Optional<T> findByEmail(String correo);
    List<User> findAllByRole(Role role);
}