package com.meditrack.service.impl;

import com.meditrack.entity.VaccineRecord;
import com.meditrack.repository.VaccineRecordRepository;
import com.meditrack.service.VaccineRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineRecordServiceImpl implements VaccineRecordService {

    @Autowired
    private VaccineRecordRepository repository;

    public List<VaccineRecord> getRecords(Long userId) {
        return repository.findByUserId(userId);
    }

    public VaccineRecord addRecord(VaccineRecord record) {
        return repository.save(record);
    }
}