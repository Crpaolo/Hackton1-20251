package com.example.hackaton20251.airequest.domain;

import com.example.hackaton20251.company.domain.Company;
import com.example.hackaton20251.user.domain.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ai_requests")
public class Airequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ModelType modelType;

    @Lob
    private String queryText;

    @Lob
    private String responseText;

    private Integer tokensConsumed;
    private LocalDateTime timestamp;
    private String fileName; // for multimodal
}
