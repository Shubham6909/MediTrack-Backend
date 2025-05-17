package com.meditrack.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "EmergencyInfo")
public class EmergencyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Blood_Group")
    private String bloodGroup;

    @Column(name = "Allergies")
    private String allergies;

    @Column(name = "EmergencyContactName")
    private String emergencyContactName;

    @Column(name = "EmergencyContactPhone")
    private String emergencyContactPhone;

    @OneToOne
    @JoinColumn(name = "User_Id", nullable = false)
    private User user;

    @Column(name = "Created_Date")
    private LocalDateTime createdAt;

    @Column(name = "Updated_Date")
    private LocalDateTime updatedAt;


    @Column(name = "Update_Count")
    private int updateCount = 0;

    // === Lifecycle Hooks ===
    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
        this.updateCount = 0;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
        this.updateCount++;
    }


    private String getCurrentFormattedDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    // === Getters and Setters ===

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
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

    public int getUpdateCount() {
        return updateCount;
    }
    public void setUpdateCount(int updateCount) {
        this.updateCount = updateCount;
    }
}
