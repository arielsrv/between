package com.between.unit.controllers;

import com.between.controllers.PriceController;
import com.between.dtos.PriceDto;
import com.between.services.PriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PriceControllerTest {

    private PriceService priceService;
    private PriceController priceController;

    @BeforeEach
    public  void setUp() {
        this.priceService = mock(PriceService.class);
        this.priceController = new PriceController(this.priceService);
    }

    @Test
    public void get_all() {
        when(this.priceService.getAll()).thenReturn(getItems());
        ArrayList<PriceDto> actual = this.priceController.getAll();
        assertThat(actual).isNotNull();
        assertThat(actual).isNotEmpty();
        assertThat(actual.stream().findFirst().isPresent()).isTrue();
        assertThat(actual.stream().findFirst().get().productId).isEqualTo(1L);
    }

    private ArrayList<PriceDto> getItems() {
        ArrayList<PriceDto> priceDtos = new ArrayList<>();

        PriceDto priceDto = new PriceDto();
        priceDto.productId = 1L;

        priceDtos.add(priceDto);

        return priceDtos;
    }
}
