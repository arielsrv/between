package com.between.dtos;

import java.time.LocalDateTime;

public class PriceDto {
	public long id;
	public LocalDateTime startDate;
	public LocalDateTime endDate;
	public long brandId;
	public int priceList;
	public int priority;
	public String currency;
	public long productId;
	public String price;
}
