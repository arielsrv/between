package com.between.services;

import com.between.dtos.PriceDto;
import com.between.entities.Brand;
import com.between.entities.Price;
import com.between.entities.Product;
import com.between.repositories.BrandRepository;
import com.between.repositories.PriceRepository;
import com.between.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PriceService {

    public BrandRepository brandRepository;
    public ProductRepository productRepository;
    public PriceRepository priceRepository;

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

    private PriceDto mapToPriceDto(Price price) {
        PriceDto priceDto = new PriceDto();
        priceDto.id = price.id;
        priceDto.startDate = price.startDate;
        priceDto.endDate = price.endDate;
        priceDto.brandId = price.brand.id;
        priceDto.priceList = price.priceList;
        priceDto.priority = price.priority;
        priceDto.currency = price.curr;
        priceDto.productId = price.product.id;
        priceDto.price = price.price;
        return priceDto;
    }

    public PriceDto getPrice(long productId, String applicationDate, long brandId) {

        Optional<Product> product = this.productRepository
                .getProduct(productId);

        if (!product.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found. ");
        }

        Optional<Brand> brand = this.brandRepository
                .getBrand(brandId);

        if (!brand.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Brand not found. ");
        }

        Optional<Price> price = this.priceRepository
                .getPrice(productId, brandId, applicationDate);

        if (!price.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Offer not found. ");
        }

        PriceDto priceDto = mapToPriceDto(price.get());

        return priceDto;
    }
}
