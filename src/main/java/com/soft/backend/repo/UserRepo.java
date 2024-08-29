package com.soft.backend.repo;

import com.soft.backend.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserInfo, Long> {
    boolean existsByEmail(String email);
}
