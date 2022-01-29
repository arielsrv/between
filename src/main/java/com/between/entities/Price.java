package com.between.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "brand_id")
    public Long brandId;

    @Column(name = "start_date")
    public LocalDateTime startDate;

    @Column(name = "end_date")
    public LocalDateTime endDate;

    @Column(name = "price_list")
    public Integer priceList;

    @Column(name = "product_id")
    public Long productId;

    @Column(name = "priority")
    public Integer priority;

    @Column(name = "price")
    public double price;

    @Column(name = "curr")
    public String curr;
}
