package com.inditex.productdetail.web.infra.inputport;

import java.sql.Date;

import com.inditex.productdetail.web.domain.Prices;

public interface PricesInputPort {

	public Prices getPrice(Date startDate, Date endDate, String productId, int brandId);
}
