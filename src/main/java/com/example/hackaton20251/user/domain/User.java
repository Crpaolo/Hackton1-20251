package com.example.hackaton20251.user.domain;

import com.example.hackaton20251.airequest.domain.Airequest;
import com.example.hackaton20251.Company.domain.Company;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)// se modifica dependiendo de las entidades hijas
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//fijo puede ser int o Long

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)//fijo
    private String email;

    @Column(nullable = false)//fijo
    private String password;

    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private LocalDate fechaDeRegistro;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserLimit> limits;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Airequest> airequests;


    @Transient
    private String rolePrefix = "ROLE_";

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rolePrefix + role.name()));
    }


    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
