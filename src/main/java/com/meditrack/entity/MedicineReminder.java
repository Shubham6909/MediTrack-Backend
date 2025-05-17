package com.meditrack.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Medicine_Reminder")
public class MedicineReminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Medicine_Name", nullable = false)
    private String medicineName;

    @Column(name = "Dosage", nullable = false)
    private String dosage;

    @Column(name = "Reminder_Time", nullable = false)
    private LocalDateTime reminderTime;

    @Column(name = "User_Phone", nullable = false)
    private String userPhone;

    @Column(name = "Created_Date")
    private String createdDate;

    @Column(name = "Updated_Date")
    private String updatedDate;

    @Column(name = "Update_Count")
    private int updateCount = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Id", nullable = false)
    private User user;

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public LocalDateTime getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(LocalDateTime reminderTime) {
        this.reminderTime = reminderTime;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // --- Utility Methods ---

    /**
     * Call this method when the reminder is created for the first time.
     */
    public void markCreated() {
        String now = getCurrentFormattedDateTime();
        this.createdDate = now;
        this.updatedDate = now;
    }

    /**
     * Call this method every time the reminder is updated.
     */
    public void markUpdated() {
        this.updatedDate = getCurrentFormattedDateTime();
        this.updateCount++;
    }

    /**
     * Utility to format LocalDateTime in dd-MM-yy HH:mm:ss format.
     */
    private String getCurrentFormattedDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
