package com.inditex.productdetail.web.app.domain.inputport;

import java.util.Date;

import com.inditex.productdetail.web.app.domain.Prices;

public interface PricesInputPort {

	public Prices getPrice(Date startDate, Date endDate, String productId, int brandId);
	public Prices getPriceById(int id);
}
