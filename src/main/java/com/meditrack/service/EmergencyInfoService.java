package com.meditrack.service;

import com.meditrack.dto.EmergencyInfoDTO;
import com.meditrack.dto.HealthDocumentDTO;
import com.meditrack.entity.EmergencyInfo;
import com.meditrack.entity.HealthDocument;
import com.meditrack.entity.User;
import com.meditrack.repository.EmergencyInfoRepository;
import com.meditrack.repository.HealthDocumentRepository;
import com.meditrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmergencyInfoService {

    @Autowired
    private EmergencyInfoRepository emergencyInfoRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private HealthDocumentRepository documentRepo;

    // ✅ POST - Create Emergency Info
    public EmergencyInfoDTO createEmergencyInfo(EmergencyInfoDTO dto) {
        User user = userRepo.findByPhone(dto.getPhone())
                .orElseThrow(() -> new RuntimeException("User not found with phone: " + dto.getPhone()));

        if (emergencyInfoRepo.findByUser(user).isPresent()) {
            throw new RuntimeException("Emergency info already exists for this user.");
        }

        EmergencyInfo info = new EmergencyInfo();
        info.setUser(user);
        info.setName(dto.getName());
        info.setBloodGroup(dto.getBloodGroup());
        info.setAllergies(dto.getAllergies());
        info.setEmergencyContactName(dto.getEmergencyContactName());
        info.setEmergencyContactPhone(dto.getEmergencyContactPhone());
        info.setCreatedAt(LocalDateTime.now());
        info.setUpdatedAt(LocalDateTime.now());
        info.setUpdateCount(0);

        emergencyInfoRepo.save(info);
        return getEmergencyInfoByPhone(dto.getPhone());
    }

    // ✅ GET - Get Emergency Info by Phone
    public EmergencyInfoDTO getEmergencyInfoByPhone(String phone) {
        User user = userRepo.findByPhone(phone)
                .orElseThrow(() -> new RuntimeException("User not found with phone: " + phone));

        EmergencyInfo info = emergencyInfoRepo.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Emergency info not found for user"));

        EmergencyInfoDTO dto = new EmergencyInfoDTO();
        dto.setPhone(user.getPhone());
        dto.setName(info.getName());
        dto.setBloodGroup(info.getBloodGroup());
        dto.setAllergies(info.getAllergies());
        dto.setEmergencyContactName(info.getEmergencyContactName());
        dto.setEmergencyContactPhone(info.getEmergencyContactPhone());
        dto.setCreatedAt(info.getCreatedAt());
        dto.setUpdatedAt(info.getUpdatedAt());

        List<HealthDocumentDTO> documents = documentRepo.findByUser(user)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        dto.setDocuments(documents);

        return dto;
    }

    // ✅ PUT - Update Emergency Info
    public EmergencyInfoDTO updateEmergencyInfo(String phone, EmergencyInfoDTO dto) {
        User user = userRepo.findByPhone(phone)
                .orElseThrow(() -> new RuntimeException("User not found with phone: " + phone));

        EmergencyInfo info = emergencyInfoRepo.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Emergency info not found for user"));

        info.setName(dto.getName());
        info.setBloodGroup(dto.getBloodGroup());
        info.setAllergies(dto.getAllergies());
        info.setEmergencyContactName(dto.getEmergencyContactName());
        info.setEmergencyContactPhone(dto.getEmergencyContactPhone());
        info.setUpdatedAt(LocalDateTime.now());
        info.setUpdateCount(info.getUpdateCount() + 1);

        emergencyInfoRepo.save(info);
        return getEmergencyInfoByPhone(phone);
    }

    // ✅ DELETE - Delete Emergency Info
    public void deleteEmergencyInfo(String phone) {
        User user = userRepo.findByPhone(phone)
                .orElseThrow(() -> new RuntimeException("User not found with phone: " + phone));

        EmergencyInfo info = emergencyInfoRepo.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Emergency info not found for user"));

        emergencyInfoRepo.delete(info);
    }

    // ✅ Utility Method - Convert HealthDocument to DTO
    private HealthDocumentDTO convertToDTO(HealthDocument doc) {
        HealthDocumentDTO d = new HealthDocumentDTO();
        d.setId(doc.getId());
        d.setDocumentName(doc.getDocumentName());
        d.setFileUrl(doc.getFileUrl());
        d.setUserPhone(doc.getUser().getPhone());
        d.setUserId(doc.getUser().getId());
        d.setCreatedDate(doc.getCreatedDate());
        d.setUpdatedDate(doc.getUpdatedDate());
        d.setUpdateCount(doc.getUpdateCount());
        return d;
    }
}
