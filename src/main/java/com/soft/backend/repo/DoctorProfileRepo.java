package com.soft.backend.repo;

import com.soft.backend.entity.DoctorInfo;
import com.soft.backend.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorProfileRepo extends JpaRepository<DoctorInfo, Long> {
    DoctorInfo findByEmail(String email);

}
