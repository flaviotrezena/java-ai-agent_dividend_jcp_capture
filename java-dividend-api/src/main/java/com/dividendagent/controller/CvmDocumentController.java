package com.dividendagent.controller;

import com.dividendagent.dto.CvmDocumentRequest;
import com.dividendagent.service.CvmDocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cvm/documents")
public class CvmDocumentController {

    private final CvmDocumentService service;

    public CvmDocumentController(CvmDocumentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> receive(
            @RequestBody CvmDocumentRequest request
    ) {
        boolean created = service.save(request);

        if (!created) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}