package com.dividendagent.service;

import com.dividendagent.dto.YahooFinanceRequest;
import com.dividendagent.entity.MarketPriceEntity;
import com.dividendagent.repository.MarketPriceRepository;
import org.springframework.stereotype.Service;

@Service
public class MarketPriceService {

    private static final String SOURCE = "YAHOO_FINANCE";

    private final MarketPriceRepository repository;

    public MarketPriceService(
            MarketPriceRepository repository
    ) {
        this.repository = repository;
    }

    public boolean save(
            YahooFinanceRequest request
    ) {
        boolean alreadyExists =
                repository.existsByTickerAndPriceDateAndSource(
                        request.ticker(),
                        request.priceDate(),
                        SOURCE
                );

        if (alreadyExists) {
            return false;
        }

        MarketPriceEntity entity =
                new MarketPriceEntity(
                        request.ticker(),
                        request.priceDate(),
                        request.openPrice(),
                        request.highPrice(),
                        request.lowPrice(),
                        request.closePrice(),
                        request.volume(),
                        SOURCE
                );

        repository.save(entity);

        return true;
    }
}