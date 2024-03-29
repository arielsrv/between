package com.between.services;

import com.between.dtos.PriceDto;
import com.between.entities.Brand;
import com.between.entities.Price;
import com.between.entities.Product;
import com.between.exceptions.ApiNotFoundException;
import com.between.repositories.BrandRepository;
import com.between.repositories.PriceRepository;
import com.between.repositories.ProductRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PriceService {

	public final BrandRepository brandRepository;
	public final ProductRepository productRepository;
	public final PriceRepository priceRepository;

	@Autowired
	public PriceService(
		ProductRepository productRepository,
		BrandRepository brandRepository,
		PriceRepository priceRepository
	) {
		this.productRepository = productRepository;
		this.brandRepository = brandRepository;
		this.priceRepository = priceRepository;
	}

	public PriceDto getPrice(long productId, String applicationDate, long brandId) {

		Optional<Product> product = this.productRepository
			.getProduct(productId);

		if (product.isEmpty()) {
			throw new ApiNotFoundException("Product not found. ");
		}

		Optional<Brand> brand = this.brandRepository
			.getBrand(brandId);

		if (brand.isEmpty()) {
			throw new ApiNotFoundException("Brand not found. ");
		}

		Optional<Price> price = this.priceRepository
			.getPrice(productId, brandId, applicationDate);

		if (price.isEmpty()) {
			throw new ApiNotFoundException("Offer not found. ");
		}

		return this.mapToPriceDto(price.get());
	}


	private PriceDto mapToPriceDto(Price price) {
		PriceDto priceDto = new PriceDto();
		priceDto.startDate = price.startDate;
		priceDto.endDate = price.endDate;
		priceDto.brandId = price.brand.id;
		priceDto.priceList = price.priceList;
		priceDto.currency = price.curr.toString();
		priceDto.productId = price.product.id;
		priceDto.price = price.price;
		return priceDto;
	}
}
