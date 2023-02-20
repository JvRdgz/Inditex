package com.inditex.productdetail.web.app.infra.outputadapter;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.inditex.productdetail.web.app.domain.Prices;
import com.inditex.productdetail.web.app.domain.outputport.EntityRepository;

@Component
public class H2Repository implements EntityRepository {

	@Autowired
	private JdbcTemplate template;

	@Override
	public Prices getPrice(Date startDate, Date endDate, String productId, int brandId) {
		String sql = "SELECT * FROM PRICES WHERE START_DATE=? AND END_DATE=? AND PRODUCT_ID=? AND BRAND_ID=? ORDER BY PRIORITY DESC";
		Prices prices = template.queryForObject(sql, new BeanPropertyRowMapper<Prices>(Prices.class),
				new Object[] { startDate, endDate, productId, brandId });
		return prices;
	}

	@Override
	public Prices getPriceById(int id) {
		String sql = "SELECT * FROM PRICES WHERE ID=?";
		Prices price = template.queryForObject(sql, new BeanPropertyRowMapper<Prices>(Prices.class),
				new Object[] { id });
		return price;
	}
}
