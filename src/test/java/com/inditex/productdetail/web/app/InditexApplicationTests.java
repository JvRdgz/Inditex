package com.inditex.productdetail.web.app;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inditex.productdetail.web.app.domain.Prices;
import com.inditex.productdetail.web.app.infra.inputadapter.PricesAPI;

@RunWith(SpringJUnit4ClassRunner.class)
class InditexApplicationTests {

	PricesAPI pricesAPI = new PricesAPI();

	@Test
	void testStatusOk() {
		boolean result = pricesAPI.status().getStatusCode().is2xxSuccessful();

		assertTrue(result);
	}

	@Test
	void testGetProduct() throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");

		Date formatStartDate = format.parse("2020-06-14 00:00:00");
		java.sql.Date startDate = new java.sql.Date(formatStartDate.getTime());
		Date formatEndDate = format.parse("2020-12-31 23:59:59");
		java.sql.Date endDate = new java.sql.Date(formatEndDate.getTime());
		String productId = "35455";
		int brandId = 1;

		Prices prices = new Prices();

		prices.setBrandId(brandId);
		prices.setId((long) 1);
		prices.setStartDate(startDate);
		prices.setEndDate(endDate);
		prices.setProductId(productId);
		prices.setPriceList(1);
		prices.setPriority(0);
		prices.setPrice(35.50);
		prices.setCurr("EUR");

		Mockito.when(pricesAPI.getPrice(Mockito.any(), Mockito.any(), Mockito.anyString(), Mockito.anyInt()))
				.thenReturn(prices);

		boolean result = pricesAPI.status().getStatusCode().is2xxSuccessful();

		assertTrue(result);

	}

}