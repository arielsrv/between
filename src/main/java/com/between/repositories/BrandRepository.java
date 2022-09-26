package com.between.repositories;

import com.between.entities.Brand;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BrandRepository {

	public final IBrandRepository brandRepository;

	@Autowired
	public BrandRepository(IBrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	public Optional<Brand> getBrand(long brandId) {
		return this.brandRepository.findById(brandId);
	}
}
