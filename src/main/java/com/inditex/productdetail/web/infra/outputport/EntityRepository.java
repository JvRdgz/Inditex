package com.inditex.productdetail.web.infra.outputport;

import java.sql.Date;

public interface EntityRepository {

	public <T> T getPrice(Long id, String productId, int priceList, Date startDate, Date endDate, Long price);
}
