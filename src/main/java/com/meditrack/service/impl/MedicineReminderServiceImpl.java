package com.meditrack.service.impl;

import com.meditrack.entity.MedicineReminder;
import com.meditrack.repository.MedicineReminderRepository;
import com.meditrack.service.MedicineReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicineReminderServiceImpl implements MedicineReminderService {

    @Autowired
    private MedicineReminderRepository repository;

    public List<MedicineReminder> getReminders(Long userId) {
        return repository.findByUserId(userId);
    }

    public MedicineReminder addReminder(MedicineReminder reminder) {
        return repository.save(reminder);
    }
}