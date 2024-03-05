package com.prueba.inditex.entity.prices;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Prices {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "brand_id")
	private Integer brandId;
	
	@Column(name = "start_date")
	private LocalDateTime startDate;
	
	@Column(name = "end_date")
	private LocalDateTime endDate;
	
	@Column(name = "price_list")
	private Integer priceList;
	
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "priority")
	private Integer priority;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "curr")
	private String curr;
	
}
