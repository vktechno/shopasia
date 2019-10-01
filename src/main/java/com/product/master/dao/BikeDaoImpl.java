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
public class BikeDaoImpl implements BikeDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> getBikeBrand() {
		String query = "SELECT brand_id as brandId, brand_name as brandName FROM product_bike_brand";
		return jdbcTemplate.queryForList(query);
	}

	@Override
	public Integer insertBikeBrand(Map<String, Object> bikeObject) {
		String query = "INSERT INTO product_bike_brand(brand_name) values(?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, (String) bikeObject.get("brandName"));
				return ps;
			}
		});
	}

	@Override
	public Integer updateBikeBrand(Map<String, Object> bikeObject) {
		String query = "UPDATE product_bike_brand set brand_name = ? where brand_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, (String) bikeObject.get("brandName"));
				ps.setInt(2, (int) bikeObject.get("brandId"));
				return ps;
			}
		});
	}

	@Override
	public List<Map<String, Object>> getBikeModel() {
		String query = "SELECT model_id as modelId, model_name as modelName, brand_id as brandId FROM product_bike_model";
		return jdbcTemplate.queryForList(query);
	}

	@Override
	public Integer insertBikeModel(Map<String, Object> bikeObject) {
		String query ="INSERT INTO product_bike_model(model_name, brand_id) values(?,?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, (String) bikeObject.get("modelName"));
				ps.setInt(2, (int) bikeObject.get("brandId"));
				return ps;
			}
		});
	}

	@Override
	public Integer updateBikeModel(Map<String, Object> bikeObject) {
		String query = "UPDATE product_bike_model set model_name = ?, brand_id = ? WHERE model_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, (String) bikeObject.get("modelName"));
				ps.setInt(2, (int) bikeObject.get("brandId"));
				ps.setInt(3, (int) bikeObject.get("modelId"));
				return ps;
			}
		});
	}

	@Override
	public Integer deleteBikeBrand(Map<String, Object> bikeObject) {
		String query = "DELETE FROM product_bike_brand WHERE brand_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, (String) bikeObject.get("brandId"));
				return ps;
			}
		});
	}

	@Override
	public Integer deleteBikeModel(Map<String, Object> bikeObject) {
		String query = "DELETE FROM product_bike_model WHERE model_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
		
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, (String) bikeObject.get("modelId"));
			return ps;
		}
	});}
	
	
}
