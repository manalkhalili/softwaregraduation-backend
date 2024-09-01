package com.soft.backend.repo;

import com.soft.backend.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserInfo, Long> {
    boolean existsByEmail(String email);

    List<UserInfo> findByName(String name);

    UserInfo findByPhoneNumber(String phoneNumber);

    UserInfo findByEmail(String email);
}
