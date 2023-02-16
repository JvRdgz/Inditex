package com.inditex.productdetail.web.app.infra.outputport;

import java.sql.Date;

import com.inditex.productdetail.web.app.domain.Prices;

public interface EntityRepository {

	// Debería de ser genérica? (No Prices)
	public Prices getPrice(Date startDate, Date endDate, String productId, int brandId);
}
