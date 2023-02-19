package com.inditex.productdetail.web.app;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inditex.productdetail.web.app.application.PriceService;
import com.inditex.productdetail.web.app.domain.Prices;
import com.inditex.productdetail.web.app.domain.inputport.PricesInputPort;
import com.inditex.productdetail.web.app.domain.outputport.EntityRepository;
import com.inditex.productdetail.web.app.infra.inputadapter.PricesAPI;
import com.inditex.productdetail.web.app.infra.outputadapter.H2Repository;

@RunWith(SpringJUnit4ClassRunner.class)
class InditexApplicationTests {

	@InjectMocks
	PricesInputPort pricesInputPort = new PriceService();

	@InjectMocks
	EntityRepository entityRepository = new H2Repository();

	@InjectMocks
	JdbcTemplate template = new JdbcTemplate();

	@InjectMocks
	PricesAPI pricesAPI = new PricesAPI();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testStatusOk() {
		boolean result = pricesAPI.status().getStatusCode().is2xxSuccessful();

		assertTrue(result);
	}

	@Test
	void testGetProduct() throws ParseException {

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

		ResponseEntity<Prices> response = new ResponseEntity<Prices>(prices, HttpStatus.OK);

		Mockito.when(this.template.queryForObject(Mockito.anyString(),
				new Object[] { Mockito.any(), Mockito.any(), Mockito.anyString(), Mockito.anyInt() },
				new BeanPropertyRowMapper<Prices>(Prices.class))).thenReturn(prices);

		Mockito.when(
				this.entityRepository.getPrice(Mockito.any(), Mockito.any(), Mockito.anyString(), Mockito.anyInt()))
				.thenReturn(prices);

		Mockito.when(this.pricesInputPort.getPrice(Mockito.any(), Mockito.any(), Mockito.anyString(), Mockito.anyInt()))
				.thenReturn(prices);

		Mockito.when(pricesAPI.getPrice(Mockito.any(), Mockito.any(), Mockito.anyString(), Mockito.anyInt()))
				.thenReturn(response);

		boolean result = pricesAPI.status().getStatusCode().is2xxSuccessful();

		assertTrue(result);

	}

}