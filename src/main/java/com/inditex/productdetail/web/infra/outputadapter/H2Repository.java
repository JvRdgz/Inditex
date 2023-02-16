package com.inditex.productdetail.web.infra.outputadapter;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.inditex.productdetail.web.domain.Prices;
import com.inditex.productdetail.web.infra.outputport.EntityRepository;

public class H2Repository implements EntityRepository {

	@Autowired
	private JdbcTemplate template;

	@Override
	public <T> T getPrice(Long id, String productId, int priceList, Date startDate, Date endDate, Long price) {
		String sql = "SELECT * FROM PRICES WHERE PRODUCT_ID='" + productId + "' AND PRICE_LIST='" + priceList
				+ "' AND START_DATE ='" + startDate + "' AND END_DATE='" + endDate + "' AND PRICE='" + price + "'";
		return (T) template.query(sql, BeanPropertyRowMapper.newInstance(Prices.class));
	}

}
