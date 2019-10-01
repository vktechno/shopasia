package com.product.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

@Repository
public class MobileDaoBrandImpl implements MobileDaoBrand{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> getMobileBrand() {
		String query = "SELECT brand_id as brandId, brand_name as brandName FROM product_mobile_brand";
		return jdbcTemplate.queryForList(query);
	}

	@Override
	public Integer insertMobileBrand(Map<String, Object> mobileObject) {
		String query = "INSERT INTO product_mobile_brand(brand_name) values(?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, (String) mobileObject.get("brandName"));
				return ps;
			}
		});
	}

	@Override
	public Integer updateMobileBrand(Map<String, Object> mobileObject) {

		String query = "UPDATE product_mobile_brand set brand_name = ? WHERE brand_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, (String) mobileObject.get("brandName"));
				ps.setString(2, (String) mobileObject.get("brandId"));
				return ps;
			}
		});
	
	}

	@Override
	public Integer deleteMobileBrand(Map<String, Object> mobileObject) {

		String query = "DELETE FROM product_mobile_brand WHERE brand_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, (String) mobileObject.get("brandId"));
				return ps;
			}
		});
	
	
	}
	
	
}
