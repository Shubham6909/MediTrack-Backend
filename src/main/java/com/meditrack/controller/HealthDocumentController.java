package com.meditrack.controller;

import com.meditrack.dto.HealthDocumentDTO;
import com.meditrack.entity.ApiResponse;
import com.meditrack.entity.HealthDocument;
import com.meditrack.service.HealthDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/health-documents")
public class HealthDocumentController {

    @Autowired
    private HealthDocumentService healthDocumentService;

    // POST - Create new document
    @PostMapping
    public ResponseEntity<ApiResponse<HealthDocumentDTO>> createDocument(
            @RequestParam Long userId,
            @RequestParam String documentName,
            @RequestParam MultipartFile file) {

        HealthDocumentDTO document = healthDocumentService.saveDocument(userId, documentName, file);
        return ResponseEntity.status(201).body(ApiResponse.success("Document uploaded successfully.", document));
    }

//    // PUT - Update existing document by ID
//    @PutMapping("/{id}")
//    public ResponseEntity<ApiResponse<HealthDocumentDTO>> updateDocument(
//            @PathVariable Long id,
//            @RequestParam(required = false) Long userId,
//            @RequestParam(required = false) String documentName,
//            @RequestParam(required = false) MultipartFile file) {
//
//        HealthDocumentDTO updatedDoc = healthDocumentService.updateDocument(id, userId, documentName, file);
//        return ResponseEntity.ok(ApiResponse.success("Document updated successfully.", updatedDoc));
//    }

//    // GET - Get document by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<ApiResponse<HealthDocument>> getDocumentById(@PathVariable Long id) {
//        HealthDocument document = healthDocumentService.getDocumentById(id);
//        return ResponseEntity.ok(ApiResponse.success("Document fetched successfully.", document));
//    }
//
//    // GET - Get documents by user phone
//    @GetMapping("/phone/{userPhone}")
//    public ResponseEntity<ApiResponse<List<HealthDocument>>> getDocumentsByPhone(@PathVariable String userPhone) {
//        List<HealthDocument> documents = healthDocumentService.getDocumentsByPhone(userPhone);
//        return ResponseEntity.ok(ApiResponse.success("Documents fetched for phone: " + userPhone, documents));
//    }
//
//    // GET - Get all documents
//    @GetMapping
//    public ResponseEntity<ApiResponse<List<HealthDocument>>> getAllDocuments() {
//        List<HealthDocument> documents = healthDocumentService.getAllDocuments();
//        return ResponseEntity.ok(ApiResponse.success("All documents fetched successfully.", documents));
//    }

    // PUT - Update existing document by ID
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<HealthDocumentDTO>> updateDocument(
            @PathVariable Long id,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) String documentName,
            @RequestParam(required = false) MultipartFile file) {

        HealthDocumentDTO updatedDoc = healthDocumentService.updateDocument(id, userId, documentName, file);
        return ResponseEntity.ok(ApiResponse.success("Document updated successfully.", updatedDoc));
    }

    // GET - Get document by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<HealthDocumentDTO>> getDocumentById(@PathVariable Long id) {
        HealthDocumentDTO document = healthDocumentService.getDocumentById(id);
        return ResponseEntity.ok(ApiResponse.success("Document fetched successfully.", document));
    }

    // GET - Get documents by user phone
    @GetMapping("/phone/{userPhone}")
    public ResponseEntity<ApiResponse<List<HealthDocumentDTO>>> getDocumentsByPhone(@PathVariable String userPhone) {
        List<HealthDocumentDTO> documents = healthDocumentService.getDocumentsByPhone(userPhone);
        return ResponseEntity.ok(ApiResponse.success("Documents fetched for phone: " + userPhone, documents));
    }

    // GET - Get all documents
    @GetMapping
    public ResponseEntity<ApiResponse<List<HealthDocumentDTO>>> getAllDocuments() {
        List<HealthDocumentDTO> documents = healthDocumentService.getAllDocuments();
        return ResponseEntity.ok(ApiResponse.success("All documents fetched successfully.", documents));
    }
}