package com.between.controllers;

import com.between.dtos.PriceDto;
import com.between.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "prices")
public class PriceController {

    public PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @RequestMapping(value = "/{product_id}", method = RequestMethod.GET)
    public @ResponseBody
    PriceDto getPrice(
            @PathVariable("product_id") Long productId,
            @RequestParam("application_date") String applicationDate,
            @RequestParam("brand_id") Long brandId
    ) {
        return this.priceService.getPrice(productId, applicationDate, brandId);
    }
}
