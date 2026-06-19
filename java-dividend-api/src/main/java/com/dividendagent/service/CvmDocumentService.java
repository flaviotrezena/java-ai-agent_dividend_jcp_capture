package com.dividendagent.service;

import com.dividendagent.dto.CvmDocumentRequest;
import com.dividendagent.entity.CvmDocumentEntity;
import com.dividendagent.repository.CvmDocumentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CvmDocumentService {

    private final CvmDocumentRepository repository;

    public CvmDocumentService(CvmDocumentRepository repository) {
        this.repository = repository;
    }

    public boolean save(CvmDocumentRequest request) {

        boolean alreadyExists =
                repository.existsByCvmCodeAndDeliveryProtocolAndVersion(
                        request.cvm_code(),
                        request.delivery_protocol(),
                        request.version()
                );

        if (alreadyExists) {
            return false;
        }

        CvmDocumentEntity entity = new CvmDocumentEntity(
                request.cnpj(),
                request.cvm_code(),
                request.company_name(),
                parseDate(request.reference_date()),
                request.category(),
                request.document_type(),
                request.species(),
                request.subject(),
                parseDate(request.delivery_date()),
                request.presentation_type(),
                request.delivery_protocol(),
                request.version(),
                request.document_url(),
                request.source()
        );

        repository.save(entity);

        return true;
    }

    private LocalDate parseDate(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }

        return LocalDate.parse(value);
    }
}
