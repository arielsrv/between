package com.between.services;

import com.between.dtos.PriceDto;
import com.between.repositories.PriceRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PriceService {

    public PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public ArrayList<PriceDto> getAll() {
        ArrayList<PriceDto> prices = new ArrayList<>();

        this.priceRepository.findAll().forEach(price -> {
            PriceDto priceDto = new PriceDto();
            priceDto.id = price.id;
            priceDto.startDate = price.startDate;
            priceDto.endDate = price.endDate;
            priceDto.brandId = price.brandId;
            priceDto.priceList = price.priceList;
            priceDto.priority = price.priority;
            priceDto.currency = price.curr;
            priceDto.productId = price.productId;
            priceDto.price = price.price;
            prices.add(priceDto);
        });

        return prices;
    }
}
