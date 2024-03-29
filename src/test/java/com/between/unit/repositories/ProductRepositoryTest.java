package com.between.unit.repositories;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.between.entities.Product;
import com.between.repositories.IProductRepository;
import com.between.repositories.ProductRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

	private IProductRepository productProxyRepository;
	private ProductRepository productRepository;

	@BeforeEach
	public void setUp() {
		this.productProxyRepository = mock(IProductRepository.class);
		this.productRepository = new ProductRepository(productProxyRepository);
	}

	@Test
	public void get_price() {
		when(this.productProxyRepository.findById(1L)).thenReturn(getProduct());
		Optional<Product> actual = this.productRepository.getProduct(1L);

		assertThat(actual).isNotNull();
		assertThat(actual.isPresent()).isTrue();
		assertThat(actual.get().id).isEqualTo(1L);
		assertThat(actual.get().title).isEqualTo("iphone");
	}

	private Optional<Product> getProduct() {
		Product product = new Product();
		product.id = 1L;
		product.title = "iphone";
		return Optional.of(product);
	}
}
