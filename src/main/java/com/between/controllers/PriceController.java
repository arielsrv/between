package com.between.controllers;

import com.between.dtos.PriceDto;
import com.between.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "prices")
public class PriceController {

    public PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<PriceDto> getAll() {
        return this.priceService.getAll();
    }
}
