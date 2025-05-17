package com.meditrack.repository;

import com.meditrack.entity.EmergencyInfo;
import com.meditrack.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmergencyInfoRepository extends JpaRepository<EmergencyInfo, Long> {
    Optional<EmergencyInfo> findByUser(User user);
    void deleteByUser(User user);
}
