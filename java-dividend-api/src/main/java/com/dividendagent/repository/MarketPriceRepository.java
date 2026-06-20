package com.dividendagent.repository;

import com.dividendagent.entity.MarketPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface MarketPriceRepository extends JpaRepository<MarketPriceEntity, Long> {

    boolean existsByTickerAndPriceDateAndSource(
            String ticker,
            LocalDate priceDate,
            String source
    );
}