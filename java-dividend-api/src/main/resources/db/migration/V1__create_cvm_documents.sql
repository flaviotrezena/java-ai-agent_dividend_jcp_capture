CREATE TABLE cvm_documents (
    id BIGSERIAL PRIMARY KEY,

    cnpj VARCHAR(30),
    cvm_code VARCHAR(20),
    company_name VARCHAR(255),

    reference_date DATE,
    category VARCHAR(255),
    document_type VARCHAR(255),
    species VARCHAR(255),
    subject TEXT,

    delivery_date DATE,
    presentation_type VARCHAR(255),
    delivery_protocol VARCHAR(100),
    version VARCHAR(20),

    document_url TEXT,
    source VARCHAR(50),

    created_at TIMESTAMP NOT NULL DEFAULT NOW(),

    CONSTRAINT uk_cvm_document UNIQUE (
        cvm_code,
        delivery_protocol,
        version
    )
);