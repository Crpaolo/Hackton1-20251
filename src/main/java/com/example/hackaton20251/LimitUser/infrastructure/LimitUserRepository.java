package com.example.hackaton20251.LimitUser.infrastructure;

import com.example.hackaton20251.LimitUser.domain.LimitUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LimitUserRepository extends JpaRepository<LimitUser, Long> {
    List<LimitUser> findByUser_Id(Long id);

}