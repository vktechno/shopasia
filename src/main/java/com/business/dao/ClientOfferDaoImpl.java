package com.business.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.business.model.ClientOfferModel;

@Repository
public class ClientOfferDaoImpl implements ClientOfferDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<ClientOfferModel> getClientOffer(int ClientId) {
		String query = "SELECT * FROM business_offer WHERE client_id = ?";
		return jdbcTemplate.query(query, new Object[]{ClientId}, new RowMapper<ClientOfferModel>(){

			@Override
			public ClientOfferModel mapRow(ResultSet rs, int arg1) throws SQLException {
				ClientOfferModel com = new ClientOfferModel();
				com.setImageVideo(rs.getString("image_video"));
				com.setOfferId(rs.getInt("offer_id"));
				com.setStartDate(rs.getString("start_date"));
				com.setEndDate(rs.getString("end_date"));
				com.setCouponCode(rs.getString("coupon_code"));
				com.setWebsiteLink(rs.getString("website_link"));
				com.setTemsAndCond(rs.getString("terms_and_cond"));
				return com;
			}
			
		});
	}

	@Override
	public Integer insertClientOffer(ClientOfferModel com) {
		String query = "INSERT INTO business_offer(client_id,image_video,start_date,end_date,coupon_code,website_link,"
				+ "terms_and_cond) values(?,?,?,?,?,?,?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, com.getClientId());
				ps.setString(2, com.getImageVideo());
				ps.setString(3, com.getStartDate());
				ps.setString(4, com.getEndDate());
				ps.setString(5, com.getCouponCode());
				ps.setString(6, com.getWebsiteLink());
				ps.setString(7, com.getTemsAndCond());
				return ps;
			}
		});
	}

	@Override
	public Integer updateClientOffer(ClientOfferModel com) {
		String query = "UPDATE business_offer set image_video = ?, start_date = ?, end_date = ?, coupon_code =?,"
				+ "website_link = ?, terms_and_cond = ? WHERE offer_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, com.getImageVideo());
				ps.setString(2, com.getStartDate());
				ps.setString(3, com.getEndDate());
				ps.setString(4, com.getCouponCode());
				ps.setString(5, com.getWebsiteLink());
				ps.setString(6, com.getTemsAndCond());
				ps.setInt(7, com.getOfferId());
				return ps;
			}
		});
	}

	@Override
	public Integer deleteClientOffer(int offerId) {
		String query = "DELETE FROM business_offer WHERE offer_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, offerId);
				return ps;
			}
		});
	}
	
	
}
