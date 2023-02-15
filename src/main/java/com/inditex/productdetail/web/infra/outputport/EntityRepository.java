package com.inditex.productdetail.web.infra.outputport;

import java.sql.Date;

public interface EntityRepository {

	public <T> T getProduct(String productId, int brandId, int priceList, Date startDate, Date endDate, Long price);
}
