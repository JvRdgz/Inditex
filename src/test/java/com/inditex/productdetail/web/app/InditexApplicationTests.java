package com.inditex.productdetail.web.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
@RunWith(SpringJUnit4ClassRunner.class)
class InditexApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void testGetProduct() throws Exception {

		mockMvc.perform(get("/product/?start-date=2020-06-15-00.00.00&product-id=35455&brand-id=1"))
				.andExpect(status().is(200)).andExpect(content().json(
						"{'productId':'35455', 'brandId': 1, 'priceList': 3, 'startDate': 2020-06-15-00.00.00, 'endDate': 2020-06-15-11.00.00, 'price': 30.50}"));

	}

}