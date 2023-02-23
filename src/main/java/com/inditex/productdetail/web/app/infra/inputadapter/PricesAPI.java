package com.inditex.productdetail.web.app.infra.inputadapter;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.productdetail.web.app.domain.Prices;
import com.inditex.productdetail.web.app.domain.inputport.PricesInputPort;

@RestController
@RequestMapping("/")
public class PricesAPI {

	@Autowired
	PricesInputPort pricesInputPort;

	@GetMapping(value = "/status")
	public ResponseEntity<String> status() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@GetMapping(value = "/price-id/{id}")
	public ResponseEntity<Prices> getPriceById(@PathVariable(name = "id") int id) {
		Prices price = pricesInputPort.getPriceById(id);
		if (null != price) {
			return new ResponseEntity<>(price, HttpStatus.OK);
		} else {
			return new ResponseEntity<Prices>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/price")
	public ResponseEntity<Prices> getPrice(
			@RequestParam("start-date") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date startDate,
			@RequestParam("end-date") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date endDate,
			@RequestParam("product-id") String producId, @RequestParam("brand-id") int brandId) {
		Prices price = pricesInputPort.getPrice(startDate, endDate, producId, brandId);
		if (null != price) {
			return new ResponseEntity<Prices>(price, HttpStatus.OK);
		} else {
			return new ResponseEntity<Prices>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/date")
	public ResponseEntity<Date> getDate() {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		Date date = time;
		return new ResponseEntity<Date>(date, HttpStatus.OK);

	}
}
