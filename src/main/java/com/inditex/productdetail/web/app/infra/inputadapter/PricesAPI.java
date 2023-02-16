package com.inditex.productdetail.web.app.infra.inputadapter;

import java.sql.Date;

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
import com.inditex.productdetail.web.app.infra.inputport.PricesInputPort;

@RestController
@RequestMapping("/")
public class PricesAPI {

	@Autowired
	PricesInputPort pricesInputPort;

	@GetMapping(value = "/status")
	public ResponseEntity<String> status() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping(value="/price-id/{id}")
	public Prices getPriceById(@PathVariable(name = "id") int id) {
		return pricesInputPort.getPriceById(id);
	}

	@PostMapping(value = "/price")
	public Prices getPrice(
			@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date startDate,
			@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date endDate,
			@RequestParam("productId") String producId, @RequestParam("brandId") int brandId) {
		return pricesInputPort.getPrice(startDate, endDate, producId, brandId);
	}
}
