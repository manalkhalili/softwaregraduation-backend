package com.soft.backend.service;

import com.soft.backend.entity.DoctorInfo;
import com.soft.backend.entity.UserInfo;
import com.soft.backend.repo.DoctorProfileRepo;
import com.soft.backend.repo.UserProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DoctorProfileService {

    @Autowired
    private DoctorProfileRepo profileRepository;

    public DoctorInfo saveProfile(DoctorInfo profile) {
        return profileRepository.save(profile);
    }

    public DoctorInfo findProfileByEmail(String email) {
        return profileRepository.findByEmail(email);
    }

    public DoctorInfo updateProfile(DoctorInfo profile) {
        return profileRepository.save(profile);
    }

    public DoctorInfo updateName(String email, String newName) {
        DoctorInfo profile = profileRepository.findByEmail(email);
        if (profile != null) {
            profile.setName(newName);
            return profileRepository.save(profile);
        }
        return null;
    }

    public DoctorInfo updatePhoneNumber(String email, String newPhoneNumber) {
        DoctorInfo profile = profileRepository.findByEmail(email);
        if (profile != null) {
            profile.setPhoneNumber(newPhoneNumber);
            return profileRepository.save(profile);
        }
        return null;
    }

    public DoctorInfo updateEmail(String currentEmail, String newEmail) {
        DoctorInfo profile = profileRepository.findByEmail(currentEmail);
        if (profile != null) {
            profile.setEmail(newEmail);
            return profileRepository.save(profile);
        }
        return null;
    }

    // New methods to update address and working hours
    public DoctorInfo updateAddress(String email, String newAddress) {
        DoctorInfo profile = profileRepository.findByEmail(email);
        if (profile != null) {
            profile.setAddress(newAddress);
            return profileRepository.save(profile);
        }
        return null;
    }

    public DoctorInfo updateWorkingHours(String email, String newWorkingHours) {
        DoctorInfo profile = profileRepository.findByEmail(email);
        if (profile != null) {
            profile.setWorkingHours(newWorkingHours);
            return profileRepository.save(profile);
        }
        return null;
    }

}
