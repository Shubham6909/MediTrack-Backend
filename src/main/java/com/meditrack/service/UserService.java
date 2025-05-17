package com.meditrack.service;

import com.meditrack.dto.UserDTO;

public interface UserService {
    UserDTO createProfile(UserDTO dto);
    UserDTO getProfile(Long id);
    UserDTO updateProfile(Long id, UserDTO dto);
}
