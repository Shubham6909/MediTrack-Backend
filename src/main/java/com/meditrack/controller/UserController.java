package com.meditrack.controller;

import com.meditrack.dto.UserDTO;
import com.meditrack.entity.ApiResponse;
import com.meditrack.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Create Profile
    @PostMapping
    public ResponseEntity<ApiResponse<UserDTO>> createProfile(@Valid @RequestBody UserDTO userDto) {
        UserDTO created = userService.createProfile(userDto);
        ApiResponse<UserDTO> response = ApiResponse.success("User profile created successfully", created);
        return ResponseEntity.status(201).body(response);
    }

    // Get Profile by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> getProfile(@PathVariable Long id) {
        UserDTO user = userService.getProfile(id);
        ApiResponse<UserDTO> response = ApiResponse.success("User profile fetched successfully", user);
        return ResponseEntity.ok(response);
    }

    // Update Profile
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> updateProfile(@PathVariable Long id, @Valid @RequestBody UserDTO userDto) {
        UserDTO updated = userService.updateProfile(id, userDto);
        ApiResponse<UserDTO> response = ApiResponse.success("User profile updated successfully", updated);
        return ResponseEntity.ok(response);
    }
}
