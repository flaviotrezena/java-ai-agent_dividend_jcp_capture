package com.dividendagent.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "market_prices",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_market_price",
                        columnNames = {
                                "ticker",
                                "price_date",
                                "source"
                        }
                )
        }
)
public class MarketPriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticker;

    @Column(name = "price_date")
    private LocalDate priceDate;

    @Column(name = "open_price")
    private BigDecimal openPrice;

    @Column(name = "high_price")
    private BigDecimal highPrice;

    @Column(name = "low_price")
    private BigDecimal lowPrice;

    @Column(name = "close_price")
    private BigDecimal closePrice;

    private Long volume;

    private String source;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    protected MarketPriceEntity() {
    }

    public MarketPriceEntity(
            String ticker,
            LocalDate priceDate,
            BigDecimal openPrice,
            BigDecimal highPrice,
            BigDecimal lowPrice,
            BigDecimal closePrice,
            Long volume,
            String source
    ) {
        this.ticker = ticker;
        this.priceDate = priceDate;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.closePrice = closePrice;
        this.volume = volume;
        this.source = source;
    }
}