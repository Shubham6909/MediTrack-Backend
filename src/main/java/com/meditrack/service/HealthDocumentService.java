package com.meditrack.service;

import com.meditrack.dto.HealthDocumentDTO;
import com.meditrack.entity.HealthDocument;
import com.meditrack.entity.User;
import com.meditrack.repository.HealthDocumentRepository;
import com.meditrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HealthDocumentService {

    @Autowired
    private HealthDocumentRepository healthDocumentRepository;

    @Autowired
    private UserRepository userRepository;

    private final String baseUploadDir = System.getProperty("user.dir") + File.separator + "uploads";

    // Create Document
    public HealthDocumentDTO saveDocument(Long userId, String documentName, MultipartFile file) {
        try {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

            String userPhone = user.getPhone();
            String cleanDocName = documentName.replaceAll(" ", "_");
            String fileName = file.getOriginalFilename().replaceAll(" ", "_");
            String uploadDir = baseUploadDir + File.separator + userPhone + File.separator + cleanDocName + File.separator;

            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String filePath = uploadDir + fileName;
            file.transferTo(new File(filePath));

            String fileUrl = "http://localhost:8080/uploads/" + userPhone + "/" + cleanDocName + "/" + fileName;

            HealthDocument doc = new HealthDocument();
            doc.setDocumentName(documentName);
            doc.setFileUrl(fileUrl);
            doc.setUser(user);
            doc.markCreated();

            HealthDocument savedDoc = healthDocumentRepository.save(doc);
            return mapToDTO(savedDoc, user);

        } catch (IOException e) {
            throw new RuntimeException("Error saving file", e);
        }
    }

    // Get Document by ID
    public HealthDocumentDTO getDocumentById(Long id) {
        HealthDocument document = healthDocumentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));
        return mapToDTO(document, document.getUser());
    }

    // Get Documents by User Phone
    public List<HealthDocumentDTO> getDocumentsByPhone(String phone) {
        List<HealthDocument> documents = healthDocumentRepository.findByUserPhone(phone);
        return documents.stream()
                .map(doc -> mapToDTO(doc, doc.getUser()))
                .collect(Collectors.toList());
    }

    // Get All Documents
    public List<HealthDocumentDTO> getAllDocuments() {
        List<HealthDocument> documents = healthDocumentRepository.findAll();
        return documents.stream()
                .map(doc -> mapToDTO(doc, doc.getUser()))
                .collect(Collectors.toList());
    }

    // Update Document
    public HealthDocumentDTO updateDocument(Long id, Long userId, String documentName, MultipartFile file) {
        HealthDocument document = healthDocumentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found with ID: " + id));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        if (documentName != null && !documentName.isEmpty()) {
            document.setDocumentName(documentName);
        }

        document.setUser(user);

        if (file != null && !file.isEmpty()) {
            try {
                String userPhone = user.getPhone();
                String cleanDocName = document.getDocumentName().replaceAll(" ", "_");
                String fileName = file.getOriginalFilename().replaceAll(" ", "_");
                String uploadDir = baseUploadDir + File.separator + userPhone + File.separator + cleanDocName + File.separator;

                File dir = new File(uploadDir);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                String fullPath = uploadDir + fileName;
                file.transferTo(new File(fullPath));

                String fileUrl = "http://localhost:8080/uploads/" + userPhone + "/" + cleanDocName + "/" + fileName;
                document.setFileUrl(fileUrl);

            } catch (IOException e) {
                throw new RuntimeException("File upload failed: " + e.getMessage());
            }
        }

        document.markUpdated();
        HealthDocument savedDoc = healthDocumentRepository.save(document);
        return mapToDTO(savedDoc, user);
    }

    // Map HealthDocument to HealthDocumentDTO
    private HealthDocumentDTO mapToDTO(HealthDocument document, User user) {
        HealthDocumentDTO dto = new HealthDocumentDTO();
        dto.setId(document.getId());
        dto.setDocumentName(document.getDocumentName());
        dto.setFileUrl(document.getFileUrl());
        dto.setUserPhone(user.getPhone());
        dto.setUserId(user.getId());
        dto.setCreatedDate(document.getCreatedDate());
        dto.setUpdatedDate(document.getUpdatedDate());
        dto.setUpdateCount(document.getUpdateCount());
        return dto;
    }
}