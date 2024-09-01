package com.soft.backend.controller;

import com.soft.backend.entity.DoctorInfo;
import com.soft.backend.entity.UserInfo;
import com.soft.backend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerDoctor(@RequestBody DoctorInfo doctor) {
        if (!isValidEmail(doctor.getEmail())) {
            return ResponseEntity.badRequest().body("Invalid email format.");
        }
        if (!isValidPassword(doctor.getPassword())) {
            return ResponseEntity.badRequest().body("Password must contain at least 10 characters, including 1 uppercase letter, 1 lowercase letter, and 1 special character.");
        }
        if (!isValidPhoneNumber(doctor.getPhoneNumber())) {
            return ResponseEntity.badRequest().body("Phone number must be exactly 10 digits.");
        }

        try {
            doctorService.registerUser(doctor);
            return ResponseEntity.ok("Doctor registered successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signInUser(@RequestBody DoctorInfo loginRequest) {
        try {

            DoctorInfo doctor = doctorService.signIndoctor(loginRequest.getEmail(), loginRequest.getPassword());

            if (doctor != null) {
                return ResponseEntity.ok("User signed in successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/signout/{id}")
    public ResponseEntity<?> signOutUser(@PathVariable Long id) {
        try {
            doctorService.signOutDoctor(id);
            return ResponseEntity.ok("User signed out successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/verify-email")
    public ResponseEntity<?> verifyEmail(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        boolean exists = doctorService.checkIfEmailExists(email);

        if (exists) {

            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<DoctorInfo>> getAllDoctors() {
        try {
            List<DoctorInfo> doctors = doctorService.getAllUsers();
            return ResponseEntity.ok(doctors);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorInfo> getDoctorById(@PathVariable Long id) {
        try {
            DoctorInfo doctor = doctorService.getDoctorById(id);
            if (doctor != null) {
                return ResponseEntity.ok(doctor);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


    @GetMapping("/search")
    public ResponseEntity<List<DoctorInfo>> getDoctorsByName(@RequestParam String name) {
        try {
            List<DoctorInfo> doctors = doctorService.getUsersByName(name);
            return ResponseEntity.ok(doctors);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/byPhoneNumber")
    public ResponseEntity<DoctorInfo> getDoctorByPhoneNumber(@RequestParam String phoneNumber) {
        try {
            DoctorInfo doctor = doctorService.getUserByPhoneNumber(phoneNumber);
            if (doctor != null) {
                return ResponseEntity.ok(doctor);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


    @GetMapping("/byEmail")
    public ResponseEntity<DoctorInfo> getDoctorByEmail(@RequestParam String email) {
        try {
            DoctorInfo doctor = doctorService.getUserByEmail(email);
            if (doctor != null) {
                return ResponseEntity.ok(doctor);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/byAddress")
    public ResponseEntity<List<DoctorInfo>> getDoctorsByAddress(@RequestParam String address) {
        try {
            List<DoctorInfo> doctors = doctorService.getUsersByAddress(address);
            if (!doctors.isEmpty()) {
                return ResponseEntity.ok(doctors);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping("/count-loggedin")
    public long countLoggedInDoctors() {
        return doctorService.countLoggedInDoctors();
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    private boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@!#%]).{10,}$";
        return password.matches(passwordRegex);
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String phoneNumberRegex = "^\\d{10}$";
        return phoneNumber.matches(phoneNumberRegex);
    }
}
