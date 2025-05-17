package com.meditrack.dto;

import com.meditrack.entity.EmergencyInfo;
import com.meditrack.entity.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setName(user.getName());
        dto.setPhone(user.getPhone());
        dto.setEmail(user.getEmail());
        dto.setAge(user.getAge());
        dto.setGender(user.getGender());
        dto.setBloodGroup(user.getBloodGroup());
        dto.setAllergies(user.getAllergies());
        dto.setLanguage(user.getLanguage());

        EmergencyInfo emergencyInfo = user.getEmergencyInfo();
        if (emergencyInfo != null) {
            dto.setEmergencyContactName(emergencyInfo.getEmergencyContactName());
            dto.setEmergencyContactPhone(emergencyInfo.getEmergencyContactPhone());

            // Optional: sync back other info from emergency
            // dto.setName(emergencyInfo.getName()); // Uncomment only if you want to override
            // dto.setBloodGroup(emergencyInfo.getBloodGroup());
            // dto.setAllergies(emergencyInfo.getAllergies());
        }

        return dto;
    }

    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        user.setAge(dto.getAge());
        user.setGender(dto.getGender());
        user.setBloodGroup(dto.getBloodGroup());
        user.setAllergies(dto.getAllergies());
        user.setLanguage(dto.getLanguage());

        if (dto.getEmergencyContactName() != null || dto.getEmergencyContactPhone() != null) {
            EmergencyInfo emergencyInfo = new EmergencyInfo();
            emergencyInfo.setEmergencyContactName(dto.getEmergencyContactName());
            emergencyInfo.setEmergencyContactPhone(dto.getEmergencyContactPhone());

            // ✅ Sync user fields to EmergencyInfo
            emergencyInfo.setName(dto.getName());
            emergencyInfo.setBloodGroup(dto.getBloodGroup());
            emergencyInfo.setAllergies(dto.getAllergies());

            emergencyInfo.setUser(user); // bidirectional link
            user.setEmergencyInfo(emergencyInfo);
        }

        return user;
    }
}
