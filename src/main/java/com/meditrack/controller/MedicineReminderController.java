package com.meditrack.controller;

import com.meditrack.entity.MedicineReminder;
import com.meditrack.service.MedicineReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicine")
public class MedicineReminderController {

    @Autowired
    private MedicineReminderService service;

    @GetMapping("/{userId}")
    public ResponseEntity<List<MedicineReminder>> getReminders(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getReminders(userId));
    }

    @PostMapping
    public ResponseEntity<MedicineReminder> add(@RequestBody MedicineReminder reminder) {
        return ResponseEntity.ok(service.addReminder(reminder));
    }
}