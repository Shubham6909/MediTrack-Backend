package com.meditrack.service;

import com.meditrack.entity.MedicineReminder;
import java.util.List;

public interface MedicineReminderService {
    List<MedicineReminder> getReminders(Long userId);
    MedicineReminder addReminder(MedicineReminder reminder);
}