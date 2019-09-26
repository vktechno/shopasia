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
public class CarDaoImpl implements CarDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> getCarBrand() {
		String query = "SELECT car_id as carId, car_name as carName FROM product_car_brand";
		return jdbcTemplate.queryForList(query);
	}

	@Override
	public Integer insertCarBrand(Map<String, Object> carObject) {
		String query = "INSERT INTO product_car_brand(car_name) values(?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, (String)carObject.get("carName"));
				return ps;
			}
		});
	}

	@Override
	public Integer updateCarBrand(Map<String, Object> carObject) {
		System.out.println("car Object "+carObject);
		String query = "UPDATE product_car_brand set car_name = ? where car_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, (String)carObject.get("carName"));
				ps.setInt(2, (int)carObject.get("carId"));
				return ps;
			}
		});
	}

	@Override
	public List<Map<String, Object>> getCarModel() {
		String query = "SELECT 	model_id as modelId, model_name as modelName, brand_id as brandId"
				+ " FROM product_car_model";
		return jdbcTemplate.queryForList(query);
	}

	@Override
	public Integer insertCarModel(Map<String, Object> carObject) {
		String query = "INSERT INTO product_car_model(model_name, brand_id) values(?,?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, (String) carObject.get("modelName"));
				ps.setInt(2, (int) carObject.get("brandId"));
				return ps;
			}
		});
	}

	@Override
	public Integer updateCarModel(Map<String, Object> carObject) {
		String query = "UPDATE product_car_model set model_name = ?, brand_id = ?"
				+ " Where model_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, (String) carObject.get("modelName"));
				ps.setInt(2, (int) carObject.get("brandId"));
				ps.setInt(3, (int) carObject.get("modelId"));
				return ps;
			}
		});
	}
	
	
}
