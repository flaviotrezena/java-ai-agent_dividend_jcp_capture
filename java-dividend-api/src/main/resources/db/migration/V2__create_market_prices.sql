CREATE TABLE market_prices (
    id BIGSERIAL PRIMARY KEY,

    ticker VARCHAR(20) NOT NULL,
    price_date DATE NOT NULL,

    open_price NUMERIC(18,6),
    high_price NUMERIC(18,6),
    low_price NUMERIC(18,6),
    close_price NUMERIC(18,6),

    volume BIGINT,

    source VARCHAR(50) NOT NULL,

    created_at TIMESTAMP NOT NULL DEFAULT NOW(),

    CONSTRAINT uk_market_price
        UNIQUE (
            ticker,
            price_date,
            source
        )
);