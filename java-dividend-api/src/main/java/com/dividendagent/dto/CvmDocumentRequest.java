package com.dividendagent.dto;

public record CvmDocumentRequest(
        String cnpj,
        String cvm_code,
        String company_name,
        String reference_date,
        String category,
        String document_type,
        String species,
        String subject,
        String delivery_date,
        String presentation_type,
        String delivery_protocol,
        String version,
        String document_url,
        String source
) {
}