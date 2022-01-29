package com.between.services;

import com.between.dtos.PriceDto;
import com.between.entities.Price;
import com.between.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PriceService {

    public PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    private PriceDto mapToPriceDto(Price price) {

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
        return priceDto;
    }

    public PriceDto getPrice(Long productId, String applicationDate, Long brandId) {

        Price price = this.priceRepository
                .getPrice(productId, brandId, applicationDate).get();

        PriceDto priceDto = mapToPriceDto(price);

        return priceDto;
    }
}
