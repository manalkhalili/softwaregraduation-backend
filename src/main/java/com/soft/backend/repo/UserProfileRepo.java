package com.soft.backend.repo;

import com.soft.backend.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepo extends JpaRepository<UserInfo, Long> {
    UserInfo findByEmail(String email);
}
