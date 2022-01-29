package com.between.repositories;

import com.between.entities.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PriceRepository {

    public IPriceRepository priceRepository;

    @Autowired
    public PriceRepository(IPriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<Price> getPrice(Long productId, Long brandId, String applicationDate) {
        return this.priceRepository.findTopByAndProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                productId,
                brandId,
                LocalDateTime.parse(applicationDate),
                LocalDateTime.parse(applicationDate)
        );
    }
}
