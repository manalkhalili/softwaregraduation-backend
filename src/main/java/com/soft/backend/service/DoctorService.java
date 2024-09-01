package com.soft.backend.service;

import com.soft.backend.entity.DoctorInfo;
import com.soft.backend.entity.UserInfo;
import com.soft.backend.repo.DoctorRepo;
import com.soft.backend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepo doctorRepo;

    @Autowired
    public DoctorService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public DoctorInfo registerUser(DoctorInfo doctor) throws Exception {
        if (doctorRepo.existsByEmail(doctor.getEmail())) {
            throw new Exception("Email is already registered.");
        }
        return doctorRepo.save(doctor);
    }

    public DoctorInfo signIndoctor(String email, String password) {
        DoctorInfo doctor = doctorRepo.findByEmail(email);

        if (doctor != null && doctor.getPassword().equals(password)) {
            doctor.setIsLoggedIn(true);
            doctorRepo.save(doctor);
            return doctor;
        } else {
            return null;
        }
    }

    public void signOutDoctor(Long id) {
        DoctorInfo doctor = doctorRepo.findById(id).orElse(null);
        if (doctor != null) {
            doctor.setIsLoggedIn(false);
            doctorRepo.save(doctor);
        }
    }

    public List<DoctorInfo> getAllUsers() {
        return doctorRepo.findAll();
    }

    public DoctorInfo getDoctorById(Long id) {
        return doctorRepo.findById(id).orElse(null);
    }


    public List<DoctorInfo> getUsersByName(String name) {
        return doctorRepo.findByName(name);
    }

    public DoctorInfo getUserByPhoneNumber(String phoneNumber) {
        return doctorRepo.findByPhoneNumber(phoneNumber);
    }

    public DoctorInfo getUserByEmail(String email) {
        return doctorRepo.findByEmail(email);
    }

    public List<DoctorInfo> getUsersByAddress(String address) {
        return doctorRepo.findByAddress(address);
    }

    public boolean checkIfEmailExists(String email) {
        return doctorRepo.existsByEmail(email);
    }
    public long countLoggedInDoctors() {
        return doctorRepo.countByIsLoggedInTrue();
    }
}
