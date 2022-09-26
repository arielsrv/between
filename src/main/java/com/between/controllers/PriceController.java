package com.between.controllers;

import com.between.dtos.PriceDto;
import com.between.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "prices")
public class PriceController {

	public final PriceService priceService;

	@Autowired
	public PriceController(PriceService priceService) {
		this.priceService = priceService;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody
	PriceDto getPrice(
		@RequestParam("product_id") long productId,
		@RequestParam("application_date") String applicationDate,
		@RequestParam("brand_id") long brandId
	) {
		return this.priceService.getPrice(productId, applicationDate, brandId);
	}
}
