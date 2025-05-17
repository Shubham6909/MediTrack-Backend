package com.meditrack.repository;

import com.meditrack.entity.MedicineReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicineReminderRepository extends JpaRepository<MedicineReminder, Long> {
    List<MedicineReminder> findByUserId(Long userId);
    List<MedicineReminder> findByUserPhone(String userPhone);
}