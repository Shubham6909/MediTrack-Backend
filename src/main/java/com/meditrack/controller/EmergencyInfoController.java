package com.meditrack.controller;

import com.meditrack.dto.EmergencyInfoDTO;
import com.meditrack.entity.ApiResponse;
import com.meditrack.service.EmergencyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emergency-info")
public class EmergencyInfoController {

    @Autowired
    private EmergencyInfoService emergencyInfoService;

    // ✅ POST - Create Emergency Info
    @PostMapping
    public ResponseEntity<ApiResponse<EmergencyInfoDTO>> createEmergencyInfo(@RequestBody EmergencyInfoDTO dto) {
        EmergencyInfoDTO created = emergencyInfoService.createEmergencyInfo(dto);
        return ResponseEntity.ok(new ApiResponse<>("Emergency info created successfully", created));
    }

    // ✅ GET - Get Emergency Info by Phone
    @GetMapping("/{phone}")
    public ResponseEntity<ApiResponse<EmergencyInfoDTO>> getEmergencyInfo(@PathVariable String phone) {
        EmergencyInfoDTO info = emergencyInfoService.getEmergencyInfoByPhone(phone);
        return ResponseEntity.ok(new ApiResponse<>("Emergency info fetched successfully", info));
    }

    // ✅ PUT - Update Emergency Info by Phone
    @PutMapping("/{phone}")
    public ResponseEntity<ApiResponse<EmergencyInfoDTO>> updateEmergencyInfo(
            @PathVariable String phone,
            @RequestBody EmergencyInfoDTO dto
    ) {
        EmergencyInfoDTO updated = emergencyInfoService.updateEmergencyInfo(phone, dto);
        return ResponseEntity.ok(new ApiResponse<>("Emergency info updated successfully", updated));
    }

    // ✅ DELETE - Delete Emergency Info by Phone
    @DeleteMapping("/{phone}")
    public ResponseEntity<ApiResponse<String>> deleteEmergencyInfo(@PathVariable String phone) {
        emergencyInfoService.deleteEmergencyInfo(phone);
        return ResponseEntity.ok(new ApiResponse<>("Emergency info deleted successfully", null));
    }
}
