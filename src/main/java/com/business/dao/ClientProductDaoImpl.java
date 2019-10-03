package com.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.business.model.ClientProductModel;

@Repository
public class ClientProductDaoImpl implements ClientProductDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> getClientProduct(int ClientId) {
		String query = "SELECT pro_id as proId, image_video as imageVideo, title, description, price"
				+ " FROM business_product WHERE client_id = ?";
		return jdbcTemplate.queryForList(query, ClientId);
	}

	@Override
	public Integer insertClientProduct(ClientProductModel cdm) {
		String query = "INSERT INTO business_product(image_video,title,description,price,client_id)"
				+ " values(?,?,?,?,?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, cdm.getImageVideo());
				ps.setString(2, cdm.getTitle());
				ps.setString(3, cdm.getDescription());
				ps.setInt(4, cdm.getPrice());
				ps.setInt(5, cdm.getClientId());
				return ps;
			}
		});
	}

	@Override
	public Integer updateClientProduct(ClientProductModel cdm) {
		String query = "UPDATE business_product set image_video = ?, title = ?, description = ?,"
				+ "price = ? WHERE pro_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, cdm.getImageVideo());
				ps.setString(2, cdm.getTitle());
				ps.setString(3, cdm.getDescription());
				ps.setInt(4, cdm.getPrice());
				ps.setInt(5, cdm.getProId());
				return ps;
			}
		});
	}

	@Override
	public Integer deleteClientProduct(int proId) {
		String query = "DELETE FROM business_product WHERE pro_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, proId);
				return ps;
			}
		});
	}
	
	
}
