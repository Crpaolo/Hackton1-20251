package com.example.hackaton20251.company.infraestructure;


import com.example.hackaton20251.airequest.domain.ModelType;
import com.example.hackaton20251.user.domain.User;
import com.example.hackaton20251.user.domain.UserLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserLimitRepository extends JpaRepository<UserLimit, Long> {

    List<UserLimit> findByUserId(Long userId);

    Optional<UserLimit> findByUserIdAndModelType(Long userId, ModelType modelType);

    List<UserLimit> findByUser(User user);
}