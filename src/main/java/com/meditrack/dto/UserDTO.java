package com.meditrack.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Phone number cannot be empty")
    private String phone;

    @Email(message = "Invalid email address")
    private String email;

    @Min(value = 1, message = "Age must be at least 1")
    private int age;

    @NotBlank(message = "Gender cannot be empty")
    private String gender;

    @NotBlank(message = "Blood Group cannot be empty")
    private String bloodGroup;

    @NotBlank(message = "Blood Group cannot be empty")
    private String allergies;

    private String language;

    @NotBlank(message = "Emergency Contact Name cannot be empty")
    private String emergencyContactName;

    @NotBlank(message = "Emergency Contact Phone cannot be empty")
    private String emergencyContactPhone;

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
}
