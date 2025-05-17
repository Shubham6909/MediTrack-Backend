package com.meditrack.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class EmergencyInfoDTO {

    private String phone;
    private String name;
    private String bloodGroup;
    private String allergies;
    private String emergencyContactName;
    private String emergencyContactPhone;
    @JsonFormat(pattern = "dd-MM-yy HH:mm:ss")
    private LocalDateTime  createdAt;
    @JsonFormat(pattern = "dd-MM-yy HH:mm:ss")
    private LocalDateTime updatedAt;
    private List<HealthDocumentDTO> documents;

    // Getters and Setters
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<HealthDocumentDTO> getDocuments() {
        return documents;
    }

    public void setDocuments(List<HealthDocumentDTO> documents) {
        this.documents = documents;
    }
}
