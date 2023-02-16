package com.inditex.productdetail.web.app.application;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inditex.productdetail.web.app.domain.Prices;
import com.inditex.productdetail.web.app.infra.inputport.PricesInputPort;
import com.inditex.productdetail.web.app.infra.outputport.EntityRepository;

@Component
public class PriceService implements PricesInputPort {

	@Autowired
	EntityRepository entityRepository;

	@Override
	public Prices getPrice(Date startDate, Date endDate, String productId, int brandId) {
		return entityRepository.getPrice(startDate, endDate, productId, brandId);
	}

}
