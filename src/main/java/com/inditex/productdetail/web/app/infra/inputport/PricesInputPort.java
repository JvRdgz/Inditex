package com.inditex.productdetail.web.app.infra.inputport;

import java.sql.Date;

import com.inditex.productdetail.web.app.domain.Prices;

public interface PricesInputPort {

	public Prices getPrice(Date startDate, Date endDate, String productId, int brandId);
}
