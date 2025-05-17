package com.meditrack.service;

import com.meditrack.entity.VaccineRecord;
import java.util.List;

public interface VaccineRecordService {
    List<VaccineRecord> getRecords(Long userId);
    VaccineRecord addRecord(VaccineRecord record);
}