package com.meditrack.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "User")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Phone", nullable = false)
    private String phone;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Age", nullable = false)
    private int age;

    @Column(name = "Gender", nullable = false)
    private String gender;

    @Column(name = "Blood_Group", nullable = false)
    private String bloodGroup;

    @Column(name = "Allergies")
    private String allergies;

    @Column(name = "Language", nullable = false)
    private String language;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EmergencyInfo emergencyInfo;

    // Getters and setters
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

    public String getAllergies() {
        return allergies;
    }
    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }


    public EmergencyInfo getEmergencyInfo() {
        return  emergencyInfo;
    }

    public void setEmergencyInfo(EmergencyInfo emergencyInfo) {
        this.emergencyInfo = emergencyInfo;
    }


}
