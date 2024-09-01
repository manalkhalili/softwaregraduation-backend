package com.soft.backend.repo;

import com.soft.backend.entity.DoctorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<DoctorInfo, Long> {


    boolean existsByEmail(String email);
    List<DoctorInfo> findByName(String name);
    DoctorInfo findByPhoneNumber(String phoneNumber);
    DoctorInfo findByEmail(String email);
    List<DoctorInfo> findByAddress(String address); // For finding by address
    List<DoctorInfo> findAll();
    long countByIsLoggedInTrue();


}
