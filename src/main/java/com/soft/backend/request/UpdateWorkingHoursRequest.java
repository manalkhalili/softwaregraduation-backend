package com.soft.backend.request;

public class UpdateWorkingHoursRequest {
    private String email;
    private String newWorkingHours;

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewWorkingHours() {
        return newWorkingHours;
    }

    public void setNewWorkingHours(String newWorkingHours) {
        this.newWorkingHours = newWorkingHours;
    }
}
