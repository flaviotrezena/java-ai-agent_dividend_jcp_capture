package com.dividendagent.controller;

import com.dividendagent.dto.YahooFinanceRequest;
import com.dividendagent.service.MarketPriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/market-prices")
public class MarketPriceController {

    private final MarketPriceService service;

    public MarketPriceController(
            MarketPriceService service
    ) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> receive(
            @RequestBody YahooFinanceRequest request
    ) {
        boolean created = service.save(
                request
        );

        if (!created) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }
}