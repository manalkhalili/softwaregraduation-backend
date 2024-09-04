package com.soft.backend.controller;

import com.soft.backend.entity.UserInfo;
import com.soft.backend.request.UpdatePasswordRequest;
import com.soft.backend.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.soft.backend.request.UpdateNameRequest;
import com.soft.backend.request.UpdatePhoneNumberRequest;
import com.soft.backend.request.UpdateEmailRequest;

@RestController
@RequestMapping("/profile")
public class UserProfileController {

    @Autowired
    private UserProfileService profileService;


    @GetMapping("/email/{email}")
    public UserInfo getProfileByEmail(@PathVariable String email) {

        return profileService.findProfileByEmail(email);
    }

    @PutMapping("/update")
    public UserInfo updateProfile(@RequestBody UserInfo profile) {

        return profileService.updateProfile(profile);
    }

    @PatchMapping("/updateName")
    public UserInfo updateName(@RequestBody UpdateNameRequest request) {
        return profileService.updateName(request.getEmail(), request.getNewName());
    }


    @PatchMapping("/updatePhoneNumber")
    public UserInfo updatePhoneNumber(@RequestBody UpdatePhoneNumberRequest request) {
        return profileService.updatePhoneNumber(request.getEmail(), request.getNewPhoneNumber() );
    }

    @PatchMapping("/updateEmail")
    public UserInfo updateEmail(@RequestBody UpdateEmailRequest request) {
        return profileService.updateEmail(request.getCurrentEmail(), request.getNewEmail());
    }



    }




