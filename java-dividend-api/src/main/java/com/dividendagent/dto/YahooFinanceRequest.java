package com.dividendagent.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record YahooFinanceRequest(
        String ticker,
        LocalDate priceDate,
        BigDecimal openPrice,
        BigDecimal highPrice,
        BigDecimal lowPrice,
        BigDecimal closePrice,
        Long volume) 
        {
}