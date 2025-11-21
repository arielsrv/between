package com.between.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;

	@ManyToOne()
	@JoinColumn(name = "brand_id")
	public Brand brand;

	@Column(name = "start_date", nullable = false)
	public LocalDateTime startDate;

	@Column(name = "end_date", nullable = false)
	public LocalDateTime endDate;

	@Column(name = "price_list", nullable = false)
	public int priceList;

	@ManyToOne()
	@JoinColumn(name = "product_id")
	public Product product;

	@Column(name = "priority", nullable = false)
	public int priority;

	@Column(name = "price", nullable = false)
	public String price;

	@Column(name = "curr", nullable = false)
	@Enumerated(value = EnumType.STRING)
	public Currency curr;
}

