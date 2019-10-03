package com.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.business.model.ClientDetailsModel;

@Repository
public class ClientDetailsDaoImpl implements ClientDetailsDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ClientDetailsModel> getClientDetails(int ClientId) {
		String query = "SELECT * FROM business_client WHERE client_id = ?";
		return jdbcTemplate.query(query,new Object[]{ClientId}, new RowMapper<ClientDetailsModel>(){

			@Override
			public ClientDetailsModel mapRow(ResultSet rs, int arg1) throws SQLException {
				ClientDetailsModel cdm = new ClientDetailsModel();
				cdm.setCatId(rs.getInt("cat_id"));
				cdm.setSubCatId(rs.getInt("sub_cat_id"));
				cdm.setBusinessName(rs.getString("business_name"));
				cdm.setContactNo(rs.getString("contact_no"));
				cdm.setLandLineNo(rs.getString("land_line_no"));
				cdm.setBussOpenDate(rs.getString("buss_open_date"));
				cdm.setBussOpenDays(rs.getString("buss_open_days"));
				cdm.setBussOpenTime(rs.getString("buss_open_time"));
				cdm.setEmail(rs.getString("email"));
				cdm.setPassword(rs.getString("password"));
				cdm.setImage(rs.getString("image"));
				return cdm;
			}
			
		});
	}

	@Override
	public Integer insertClientDetails(ClientDetailsModel cdm) {
		String query = "INSERT INTO business_client(cat_id,sub_cat_id,business_name,contact_no,land_line_no,"
				+ "buss_open_date,email,password) values(?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, cdm.getCatId());
				ps.setInt(2, cdm.getSubCatId());
				ps.setString(3, cdm.getBusinessName());
				ps.setString(4, cdm.getContactNo());
				ps.setString(5, cdm.getLandLineNo());
				ps.setString(6, cdm.getBussOpenDate());
				ps.setString(7, cdm.getEmail());
				ps.setString(8, cdm.getPassword());
				return ps;
			}
		});
	}

	@Override
	public Integer updateClientDetails(ClientDetailsModel cdm) {
		String query = "UPDATE business_client set cat_id = ?, sub_cat_id = ?, business_name = ?, contact_no = ?,"
				+ "land_line_no = ?, buss_open_date = ?, buss_open_days = ?, buss_open_time = ?, email =?,"
				+ "password = ?, image = ? WHERE client_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, cdm.getCatId());
				ps.setInt(2, cdm.getSubCatId());
				ps.setString(3, cdm.getBusinessName());
				ps.setString(4, cdm.getContactNo());
				ps.setString(5, cdm.getLandLineNo());
				ps.setString(6, cdm.getBussOpenDate());
				ps.setString(7, cdm.getBussOpenDays());
				ps.setString(8, cdm.getBussOpenTime());
				ps.setString(9, cdm.getEmail());
				ps.setString(10, cdm.getPassword());
				ps.setString(11, cdm.getImage());
				ps.setInt(12, cdm.getClientId());
				return ps;
			}
		});
	}

}
