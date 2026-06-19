package com.dividendagent.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "cvm_documents")
public class CvmDocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpj;

    @Column(name = "cvm_code")
    private String cvmCode;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "reference_date")
    private LocalDate referenceDate;

    private String category;

    @Column(name = "document_type")
    private String documentType;

    private String species;

    @Column(columnDefinition = "TEXT")
    private String subject;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "presentation_type")
    private String presentationType;

    @Column(name = "delivery_protocol")
    private String deliveryProtocol;

    private String version;

    @Column(name = "document_url", columnDefinition = "TEXT")
    private String documentUrl;

    private String source;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    protected CvmDocumentEntity() {
    }

    public CvmDocumentEntity(
            String cnpj,
            String cvmCode,
            String companyName,
            LocalDate referenceDate,
            String category,
            String documentType,
            String species,
            String subject,
            LocalDate deliveryDate,
            String presentationType,
            String deliveryProtocol,
            String version,
            String documentUrl,
            String source
    ) {
        this.cnpj = cnpj;
        this.cvmCode = cvmCode;
        this.companyName = companyName;
        this.referenceDate = referenceDate;
        this.category = category;
        this.documentType = documentType;
        this.species = species;
        this.subject = subject;
        this.deliveryDate = deliveryDate;
        this.presentationType = presentationType;
        this.deliveryProtocol = deliveryProtocol;
        this.version = version;
        this.documentUrl = documentUrl;
        this.source = source;
    }
}