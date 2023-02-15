package com.inditex.productdetail.web.infra.outputadapter;

import java.sql.Date;

import com.inditex.productdetail.web.infra.outputport.EntityRepository;

public class H2Repository implements EntityRepository{

	@Override
	public <T> T getProduct(String productId, int brandId, int priceList, Date startDate, Date endDate, Long price) {
		// TODO Auto-generated method stub
		return null;
	}

}
