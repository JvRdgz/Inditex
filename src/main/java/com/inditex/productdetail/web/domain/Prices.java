package com.inditex.productdetail.web.domain;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Prices {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name = "BRAND_ID")
	private Long brandId;
	@Column(name = "START_DATE")
	private Date startDate;
	@Column(name = "END_DATE")
	private Date endDate;
	@Column(name = "PRICE_LIST")
	private int priceList;
	@Column(name = "PRODUCT_ID")
	private String productId;
	@Column(name = "PRIORITY")
	private int priority;
	@Column(name = "PRICE")
	private Double price;
	@Column(name = "CURR")
	private String curr;
}
