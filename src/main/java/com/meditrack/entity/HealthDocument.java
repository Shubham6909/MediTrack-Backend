package com.meditrack.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Health_Document")
public class HealthDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Document_Name")
    private String documentName;

    @Column(name = "File_Url")
    private String fileUrl;

    @Column(name = "User_Phone")
    private String userPhone;

    @Column(name = "Created_Date")
    private String createdDate;

    @Column(name = "UpDate_Date")
    private String updatedDate;

    @Column(name = "UpDate_Count")
    private int updateCount = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Id", nullable = false)
    private User user;

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        if (user != null) {
            this.userPhone = user.getPhone();
        }
    }

    public Long getUserId() {
        return user != null ? user.getId() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    // Call this when saving first time
    public void markCreated() {
        String now = getCurrentFormattedDateTime();
        this.createdDate = now;
        this.updatedDate = now;
    }

    // Call this whenever document is updated
    public void markUpdated() {
        this.updatedDate = getCurrentFormattedDateTime();
        this.updateCount++;
    }

    private String getCurrentFormattedDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    public String getCreatedAt() {
        return createdDate;
    }

    public String getUpdatedAt() {
        return updatedDate;
    }
}