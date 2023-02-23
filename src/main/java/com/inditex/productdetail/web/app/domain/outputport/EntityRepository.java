package com.inditex.productdetail.web.app.domain.outputport;

import java.util.Date;

import com.inditex.productdetail.web.app.domain.Prices;

public interface EntityRepository {

	public Prices getPrice(Date startDate, Date endDate, String productId, int brandId);
	public Prices getPriceById(int id);
}
