package com.between.repositories;

import com.between.entities.Price;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PriceRepository {

	public final IPriceRepository priceRepository;

	@Autowired
	public PriceRepository(IPriceRepository priceRepository) {
		this.priceRepository = priceRepository;
	}

	public Optional<Price> getPrice(long productId, long brandId, String applicationDate) {
		return this.priceRepository.getPriceByApplicationDate(productId,
			brandId,
			LocalDateTime.parse(applicationDate));
	}
}
