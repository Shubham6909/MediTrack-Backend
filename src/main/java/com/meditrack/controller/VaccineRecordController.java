package com.meditrack.controller;

import com.meditrack.entity.VaccineRecord;
import com.meditrack.service.VaccineRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaccine")
public class VaccineRecordController {

    @Autowired
    private VaccineRecordService service;

    @GetMapping("/{userId}")
    public ResponseEntity<List<VaccineRecord>> getAll(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getRecords(userId));
    }

    @PostMapping
    public ResponseEntity<VaccineRecord> add(@RequestBody VaccineRecord record) {
        return ResponseEntity.ok(service.addRecord(record));
    }
}