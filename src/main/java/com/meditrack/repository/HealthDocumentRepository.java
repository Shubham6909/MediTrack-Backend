package com.meditrack.repository;

import com.meditrack.entity.HealthDocument;
import com.meditrack.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthDocumentRepository extends JpaRepository<HealthDocument, Long> {
    List<HealthDocument> findByUserPhone(String userPhone);
    List<HealthDocument> findByUser(User user);
}
