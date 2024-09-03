package com.soft.backend.service;

import com.soft.backend.entity.UserInfo;
import com.soft.backend.entity.UserInfo;
import com.soft.backend.repo.UserProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepo profileRepository;

    public UserInfo saveProfile(UserInfo profile) {
        return profileRepository.save(profile);
    }

    public UserInfo findProfileByEmail(String email) {
        return profileRepository.findByEmail(email);
    }

    public UserInfo updateProfile(UserInfo profile) {
        return profileRepository.save(profile);
    }

    public UserInfo updateName(String email, String newName) {
        UserInfo profile = profileRepository.findByEmail(email);
        if (profile != null) {
            profile.setName(newName);
            return profileRepository.save(profile);
        }
        return null;
    }

    public UserInfo updatePhoneNumber(String email, String newPhoneNumber) {
        UserInfo profile = profileRepository.findByEmail(email);
        if (profile != null) {
            profile.setPhoneNumber(newPhoneNumber);
            return profileRepository.save(profile);
        }
        return null;
    }

    public UserInfo updateEmail(String currentEmail, String newEmail) {
        UserInfo profile = profileRepository.findByEmail(currentEmail);
        if (profile != null) {
            profile.setEmail(newEmail);
            return profileRepository.save(profile);
        }
        return null;
    }
}
