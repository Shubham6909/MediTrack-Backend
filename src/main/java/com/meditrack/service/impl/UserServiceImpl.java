package com.meditrack.service.impl;

import com.meditrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meditrack.dto.UserDTO;
import com.meditrack.dto.UserMapper;
import com.meditrack.entity.User;
import com.meditrack.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createProfile(UserDTO dto) {
        User user = UserMapper.toEntity(dto);
        User saved = userRepository.save(user);
        return UserMapper.toDTO(saved);
    }

    @Override
    public UserDTO getProfile(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.toDTO(user);
    }

    @Override
    public UserDTO updateProfile(Long id, UserDTO dto) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existing.setName(dto.getName());
        existing.setPhone(dto.getPhone());
        existing.setEmail(dto.getEmail());
        existing.setAge(dto.getAge());
        existing.setGender(dto.getGender());
        existing.setBloodGroup(dto.getBloodGroup());
        existing.setAllergies(dto.getAllergies());
        existing.setLanguage(dto.getLanguage());

        // emergency contact update
        existing.getEmergencyInfo().setEmergencyContactName(dto.getEmergencyContactName());
        existing.getEmergencyInfo().setEmergencyContactPhone(dto.getEmergencyContactPhone());

        User updated = userRepository.save(existing);
        return UserMapper.toDTO(updated);
    }
}
