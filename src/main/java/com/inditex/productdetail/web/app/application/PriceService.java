package com.inditex.productdetail.web.app.application;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inditex.productdetail.web.app.domain.Prices;
import com.inditex.productdetail.web.app.domain.inputport.PricesInputPort;
import com.inditex.productdetail.web.app.domain.outputport.EntityRepository;

@Component
public class PriceService implements PricesInputPort {

	@Autowired
	EntityRepository entityRepository;

	@Override
	public Prices getPrice(Date startDate, Date endDate, String productId, int brandId) {
		return entityRepository.getPrice(startDate, endDate, productId, brandId);
	}

	@Override
	public Prices getPriceById(int id) {
		return entityRepository.getPriceById(id);
	}

}
