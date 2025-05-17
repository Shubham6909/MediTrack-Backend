package com.meditrack.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class VaccineRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vaccineName;
    private LocalDate dateGiven;
    private String givenTo;
    private Long userId;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public LocalDate getDateGiven() {
        return dateGiven;
    }

    public void setDateGiven(LocalDate dateGiven) {
        this.dateGiven = dateGiven;
    }

    public String getGivenTo() {
        return givenTo;
    }

    public void setGivenTo(String givenTo) {
        this.givenTo = givenTo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}