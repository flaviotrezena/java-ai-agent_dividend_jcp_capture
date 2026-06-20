package com.dividendagent.service;

import com.dividendagent.dto.YahooFinanceRequest;
import com.dividendagent.entity.MarketPriceEntity;
import com.dividendagent.repository.MarketPriceRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MarketPriceServiceTest {

    private final MarketPriceRepository repository =
            mock(MarketPriceRepository.class);

    private final MarketPriceService service =
            new MarketPriceService(repository);

    @Test
    @DisplayName("Deve salvar preço quando ainda não existe")
    void shouldSaveWhenMarketPriceDoesNotExist() {
        YahooFinanceRequest request = createRequest();

        when(repository.existsByTickerAndPriceDateAndSource(
                "BBAS3",
                LocalDate.of(2026, 6, 19),
                "YAHOO_FINANCE"
        )).thenReturn(false);

        boolean result = service.save(request);

        assertTrue(result);

        ArgumentCaptor<MarketPriceEntity> captor =
                ArgumentCaptor.forClass(MarketPriceEntity.class);

        verify(repository).save(captor.capture());
    }

    @Test
    @DisplayName("Não deve salvar preço duplicado")
    void shouldNotSaveWhenMarketPriceAlreadyExists() {
        YahooFinanceRequest request = createRequest();

        when(repository.existsByTickerAndPriceDateAndSource(
                "BBAS3",
                LocalDate.of(2026, 6, 19),
                "YAHOO_FINANCE"
        )).thenReturn(true);

        boolean result = service.save(request);

        assertFalse(result);

        verify(repository, never()).save(any());
    }

    private YahooFinanceRequest createRequest() {
        return new YahooFinanceRequest(
                "BBAS3",
                LocalDate.of(2026, 6, 19),
                new BigDecimal("27.50"),
                new BigDecimal("27.90"),
                new BigDecimal("27.30"),
                new BigDecimal("27.85"),
                15328400L
        );
    }
}