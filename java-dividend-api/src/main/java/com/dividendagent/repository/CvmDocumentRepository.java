package com.dividendagent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dividendagent.entity.CvmDocumentEntity;

public interface CvmDocumentRepository extends JpaRepository<CvmDocumentEntity, Long> {

    boolean existsByCvmCodeAndDeliveryProtocolAndVersion(
            String cvmCode,
            String deliveryProtocol,
            String version
    );
}