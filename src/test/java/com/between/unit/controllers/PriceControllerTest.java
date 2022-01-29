package com.between.unit.controllers;

import com.between.controllers.PriceController;
import com.between.dtos.PriceDto;
import com.between.services.PriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PriceControllerTest {

    private PriceService priceService;
    private PriceController priceController;

    @BeforeEach
    public void setUp() {
        this.priceService = mock(PriceService.class);
        this.priceController = new PriceController(this.priceService);
    }

    @Test
    public void get_price() {
        when(this.priceService.getPrice(1L, "2020-06-14T10:00:00", 1L)).thenReturn(getItem());
        PriceDto actual = this.priceController.getPrice(1L, "2020-06-14T10:00:00", 1L);
        assertThat(actual).isNotNull();
        assertThat(actual.productId).isEqualTo(1L);
    }

    private PriceDto getItem() {
        PriceDto priceDto = new PriceDto();
        priceDto.productId = 1L;
        return priceDto;
    }
}
