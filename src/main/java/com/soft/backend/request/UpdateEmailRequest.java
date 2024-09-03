package com.soft.backend.request;

public class UpdateEmailRequest {
    private String currentEmail;
    private String newEmail;

    // Getters and Setters
    public String getCurrentEmail() {
        return currentEmail;
    }

    public void setCurrentEmail(String currentEmail) {
        this.currentEmail = currentEmail;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
}
