package com.meditrack.repository;

import com.meditrack.entity.VaccineRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VaccineRecordRepository extends JpaRepository<VaccineRecord, Long> {
    List<VaccineRecord> findByUserId(Long userId);
}