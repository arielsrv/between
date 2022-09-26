package com.between.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

