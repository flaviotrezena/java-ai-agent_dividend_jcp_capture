package com.dividendagent.controller;

import com.dividendagent.service.MarketPriceService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MarketPriceControllerTest {

    private final MarketPriceService service =
            mock(MarketPriceService.class);

    private final MarketPriceController controller =
            new MarketPriceController(service);

    @Test
    @DisplayName("Deve retornar 201 quando o preço for salvo")
    void shouldReturnCreatedWhenMarketPriceIsSaved() {
        when(service.save(any())).thenReturn(true);

        ResponseEntity<Void> response =
                controller.receive(null);

        assertEquals(
                HttpStatus.CREATED,
                response.getStatusCode()
        );
    }

    @Test
    @DisplayName("Deve retornar 409 quando o preço já existir")
    void shouldReturnConflictWhenMarketPriceAlreadyExists() {
        when(service.save(any())).thenReturn(false);

        ResponseEntity<Void> response =
                controller.receive(null);

        assertEquals(
                HttpStatus.CONFLICT,
                response.getStatusCode()
        );
    }
}