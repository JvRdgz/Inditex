package com.inditex.productdetail.web.infra.inputadapter;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.productdetail.web.domain.Prices;
import com.inditex.productdetail.web.infra.inputport.PricesInputPort;

@RestController
@RequestMapping("/product")
public class PricesAPI {

	@Autowired
	PricesInputPort pricesInputPort;

	@GetMapping(value = "/status")
	public ResponseEntity<String> status() {
		System.out.print("HOLAAAA");
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@PostMapping(value = "/price", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public Prices getPrice(@RequestParam Date startDate, @RequestParam Date endDate, @RequestParam String producId,
			@RequestParam int brandId) {
		return pricesInputPort.getPrice(startDate, endDate, producId, brandId);
	}
}
