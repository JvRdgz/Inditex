package com.inditex.productdetail.web.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import com.inditex.productdetail.web.app.application.PriceService;
import com.inditex.productdetail.web.app.domain.Prices;
import com.inditex.productdetail.web.app.domain.inputport.PricesInputPort;
import com.inditex.productdetail.web.app.domain.outputport.EntityRepository;
import com.inditex.productdetail.web.app.infra.inputadapter.PricesAPI;
import com.inditex.productdetail.web.app.infra.outputadapter.H2Repository;

@SpringBootTest
class InditexApplicationTests {

	@Autowired
	PricesInputPort pricesInputPort;

	@Autowired
	EntityRepository entityRepository;

	// JdbcTemplate template = new JdbcTemplate();

	@Autowired
	JdbcTemplate template;

	@InjectMocks
	PricesAPI pricesAPI = new PricesAPI();

	@Test
	void testGetProduct() throws ParseException {

		Prices prices = getData();
		// String sql = "SELECT * FROM PRICES WHERE START_DATE=? AND END_DATE=? AND PRODUCT_ID=? AND BRAND_ID=? ORDER BY PRIORITY DESC";

		// ResponseEntity<Prices> response = new ResponseEntity<Prices>(prices, HttpStatus.OK);

		// ReflectionTestUtils.setField(prices, "template", template);

		// Mockito.when(template.queryForObject(Mockito.anyString(), Mockito.eq(Prices.class))).thenReturn(prices);

		Mockito.when(entityRepository.getPrice(prices.getStartDate(), prices.getEndDate(), prices.getProductId(),
				prices.getBrandId())).thenReturn(prices);

		Mockito.when(pricesInputPort.getPrice(Mockito.any(), Mockito.any(), Mockito.anyString(), Mockito.anyInt()))
				.thenReturn(prices);

//		Mockito.when(pricesAPI.getPrice(Mockito.any(), Mockito.any(), Mockito.anyString(), Mockito.anyInt()))
//				.thenReturn(response);

		assertNotNull(pricesAPI.getPrice(prices.getStartDate(), prices.getEndDate(), prices.getProductId(),
				prices.getBrandId()));

//		boolean result = pricesAPI
//				.getPrice(prices.getStartDate(), prices.getEndDate(), prices.getProductId(), prices.getBrandId())
//				.getStatusCode().is2xxSuccessful();

		// assertTrue(result);

	}

	public Prices getData() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss");
		Prices prices = new Prices();

		prices.setBrandId(1);
		prices.setId((long) 1);
		prices.setStartDate(format.parse("2020-06-14T00:00:00"));
		prices.setEndDate(format.parse("2020-12-31T23:59:59"));
		prices.setProductId("35455");
		prices.setPriceList(1);
		prices.setPriority(0);
		prices.setPrice(35.50);
		prices.setCurr("EUR");

		return prices;
	}

//	public Prices getData2() throws ParseException {
//		SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss");
//		Prices prices = new Prices();
//
//		prices.setBrandId(1);
//		prices.setId((long) 2);
//		prices.setStartDate(format.parse("2020-06-15T00:00:00"));
//		prices.setEndDate(format.parse("2020-12-21T23:59:59"));
//		prices.setProductId("35455");
//		prices.setPriceList(1);
//		prices.setPriority(0);
//		prices.setPrice(30.50);
//		prices.setCurr("EUR");
//
//		return prices;
//	}
//
//	public Prices getData3() throws ParseException {
//		SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss");
//		Prices prices = new Prices();
//
//		prices.setBrandId(1);
//		prices.setId((long) 3);
//		prices.setStartDate(format.parse("2020-06-16T00:00:00"));
//		prices.setEndDate(format.parse("2020-12-26T23:59:59"));
//		prices.setProductId("35455");
//		prices.setPriceList(1);
//		prices.setPriority(0);
//		prices.setPrice(40.50);
//		prices.setCurr("EUR");
//
//		return prices;
//	}

}