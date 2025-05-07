package com.example.hackaton20251.user.domain;

import com.example.hackaton20251.airequest.domain.ModelType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_limits")
public class UserLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ModelType modelType;

    @Column(nullable = false)
    private Integer usageLimit;

    @Column(nullable = false)
    private String limitType; // TOKENS or REQUESTS

    private String window; // e.g., \"24h\"
}

