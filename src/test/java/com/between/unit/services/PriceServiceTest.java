package com.between.unit.services;

import com.between.dtos.PriceDto;
import com.between.entities.Brand;
import com.between.entities.Price;
import com.between.entities.Product;
import com.between.exceptions.ApiNotFoundException;
import com.between.repositories.BrandRepository;
import com.between.repositories.PriceRepository;
import com.between.repositories.ProductRepository;
import com.between.services.PriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PriceServiceTest {

	private ProductRepository productRepository;
	private BrandRepository brandRepository;
	private PriceRepository priceRepository;
	private PriceService priceService;

	@BeforeEach
	public void setUp() {
		this.productRepository = mock(ProductRepository.class);
		this.brandRepository = mock(BrandRepository.class);
		this.priceRepository = mock(PriceRepository.class);
		this.priceService = new PriceService(
			this.productRepository,
			this.brandRepository,
			this.priceRepository
		);
	}

	@Test
	public void get_price() {
		when(this.productRepository.getProduct(1L)).thenReturn(getProduct());
		when(this.brandRepository.getBrand(1L)).thenReturn(getBrand());
		when(this.priceRepository.getPrice(1L, 1L, "2020-06-14T16:00:00")).thenReturn(getPrice());

		PriceDto actual = this.priceService.getPrice(1L, "2020-06-14T16:00:00", 1L);
		assertThat(actual).isNotNull();
	}

	@Test
	public void get_price_not_found() {
		when(this.productRepository.getProduct(1L)).thenReturn(getProduct());
		when(this.brandRepository.getBrand(1L)).thenReturn(getBrand());
		when(this.priceRepository.getPrice(1L, 1L, "2020-06-14T16:00:00")).thenThrow(new ApiNotFoundException("Price not found. "));

		assertThrows(ApiNotFoundException.class, () -> this.priceService.getPrice(1L, "2020-06-14T16:00:00", 1L));
	}

	private Optional<Price> getPrice() {
		Price price = new Price();
		price.product = new Product();
		price.product.id = 1L;
		price.brand = new Brand();
		price.brand.id = 1L;
		price.price = "20.00";
		return Optional.of(price);
	}

	private Optional<Brand> getBrand() {
		Brand brand = new Brand();
		brand.id = 1L;
		brand.title = "ZARA";
		return Optional.of(brand);
	}

	private Optional<Product> getProduct() {
		Product product = new Product();
		product.id = 1L;
		return Optional.of(product);
	}
}
