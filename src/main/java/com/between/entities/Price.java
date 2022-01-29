package com.between.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "brand_id", nullable = false)
    public Long brandId;

    @Column(name = "start_date", nullable = false)
    public LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    public LocalDateTime endDate;

    @Column(name = "price_list", nullable = false)
    public Integer priceList;

    @Column(name = "product_id", nullable = false)
    public Long productId;

    @Column(name = "priority", nullable = false)
    public Integer priority;

    @Column(name = "price", nullable = false)
    public String price;

    @Column(name = "curr", nullable = false)
    public String curr;
}
