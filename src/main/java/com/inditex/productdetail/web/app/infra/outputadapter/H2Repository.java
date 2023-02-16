package com.inditex.productdetail.web.app.infra.outputadapter;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.inditex.productdetail.web.app.domain.Prices;
import com.inditex.productdetail.web.app.infra.outputport.EntityRepository;

@Component
public class H2Repository implements EntityRepository {

	@Autowired
	private JdbcTemplate template;

	// También debería de ser genérica? (No Prices)
	@Override
	public Prices getPrice(Date startDate, Date endDate, String productId, int brandId) {
		String sql = "SELECT * FROM PRICES WHERE START_DATE='" + startDate + "' AND END_DATE='" + endDate
				+ "' AND PRODUCT_ID='" + productId + "' AND BRAND_ID='" + brandId + "'";
		return (Prices) template.query(sql, BeanPropertyRowMapper.newInstance(Prices.class));
	}

}
