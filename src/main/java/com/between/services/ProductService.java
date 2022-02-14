package com.between.services;

import com.between.controllers.topics.PriceTopic;
import com.between.dtos.CreateProductRequestDto;
import com.between.entities.Product;
import com.between.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ProductService {

	public final ProductRepository productRepository;

	public final PriceTopic priceTopic;

	@Autowired
	public ProductService(
		ProductRepository productRepository,
		PriceTopic priceTopic
	) {
		this.productRepository = productRepository;
		this.priceTopic = priceTopic;
	}

	public void create(CreateProductRequestDto createProductRequestDto) {

		Product product = new Product();
		product.title = createProductRequestDto.title;

		this.productRepository.create(product);

		this.priceTopic.send(String.valueOf(product.id));
	}
}
