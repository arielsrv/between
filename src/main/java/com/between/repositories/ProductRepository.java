package com.between.repositories;

import com.between.entities.Product;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ProductRepository {

	final IProductRepository productRepository;

	@Autowired
	public ProductRepository(IProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Optional<Product> getProduct(long productId) {
		return this.productRepository.findById(productId);
	}
}
