package com.inditex.productdetail.web.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.inditex.productdetail.web.app.domain.Prices;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void getStatus() throws Exception {
		ResponseEntity<String> response = restTemplate
				.getForEntity(new URL("http://localhost:" + port + "/status").toString(), String.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
	}

	@Test
	void getPrices() throws Exception {
		Prices prices = getData();
		URL url = new URL("http://localhost:" + port
				+ "/price?start-date=2020-06-14T00:00:00&end-date=2020-12-31T23:59:59&product-id="
				+ prices.getProductId() + "&brand-id=" + prices.getBrandId());

		ResponseEntity<Prices> response = restTemplate.postForEntity(url.toString(), prices, Prices.class);
		System.out.print("Response Status code: " + response.getStatusCode());
		assertTrue(response.getStatusCode().is2xxSuccessful());
	}

	@Test
	void getPriceById() throws Exception {
		Prices prices = getData();

		URL url = new URL("http://localhost:" + port + "/price-id/" + prices.getId());

		ResponseEntity<Prices> response = restTemplate.getForEntity(url.toString(), Prices.class);

		assertTrue(response.getStatusCode().is2xxSuccessful());
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
}
