package com.between.dtos;

import java.time.LocalDateTime;

public class PriceDto {
    public Long id;
    public LocalDateTime startDate;
    public LocalDateTime endDate;
    public Long brandId;
    public Integer priceList;
    public Integer priority;
    public String currency;
    public Long productId;
    public double price;
}
