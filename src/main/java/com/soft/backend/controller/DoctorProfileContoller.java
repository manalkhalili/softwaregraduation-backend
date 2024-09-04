package com.soft.backend.controller;

import com.soft.backend.entity.DoctorInfo;
import com.soft.backend.entity.UserInfo;
import com.soft.backend.request.*;
import com.soft.backend.service.DoctorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctorProfile")
public class DoctorProfileContoller {
    @Autowired
    private DoctorProfileService profileService;

    @GetMapping("/email/{email}")
    public DoctorInfo getProfileByEmail(@PathVariable String email) {
        return profileService.findProfileByEmail(email);
    }
    @PatchMapping("/updateName")
    public DoctorInfo updateName(@RequestBody UpdateNameRequest request) {
        return profileService.updateName(request.getEmail(), request.getNewName());
    }

    @PatchMapping("/updatePhoneNumber")
    public DoctorInfo updatePhoneNumber(@RequestBody UpdatePhoneNumberRequest request) {
        return profileService.updatePhoneNumber(request.getEmail(), request.getNewPhoneNumber() );
    }

    @PatchMapping("/updateEmail")
    public DoctorInfo updateEmail(@RequestBody UpdateEmailRequest request) {
        return profileService.updateEmail(request.getCurrentEmail(), request.getNewEmail());
    }

    @PatchMapping("/updateAddress")
    public DoctorInfo updateAddress(@RequestBody UpdateAddressRequest request) {
        return profileService.updateAddress(request.getEmail(), request.getNewAddress());
    }

    @PatchMapping("/updateWorkingHours")
    public DoctorInfo updateWorkingHours(@RequestBody UpdateWorkingHoursRequest request) {
        return profileService.updateWorkingHours(request.getEmail(), request.getNewWorkingHours());
    }

}
