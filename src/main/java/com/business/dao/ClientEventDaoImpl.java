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

import com.business.model.ClientEventModel;

@Repository
public class ClientEventDaoImpl implements ClientEventDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<ClientEventModel> getClientEvent(int ClientId) {
		String query = "SELECT * FROM business_event WHERE client_id = ?";
		return jdbcTemplate.query(query, new Object[]{ClientId}, new RowMapper<ClientEventModel>(){

			@Override
			public ClientEventModel mapRow(ResultSet rs, int arg1) throws SQLException {
				ClientEventModel cem = new ClientEventModel();
				cem.setImageVideo(rs.getString("image_video"));
				cem.setEventId(rs.getInt("event_id"));
				cem.setTitle(rs.getString("title"));
				cem.setDescription(rs.getString("description"));
				cem.setStartDate(rs.getString("start_date"));
				cem.setEndDate(rs.getString("end_date"));
				return cem;
			}
			
		});
	}

	@Override
	public Integer insertClientEvent(ClientEventModel cem) {
		String query = "INSERT INTO business_event(client_id,image_video,title,description,start_date,end_date)"
				+ " values(?,?,?,?,?,?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, cem.getClientId());
				ps.setString(2, cem.getImageVideo());
				ps.setString(3, cem.getTitle());
				ps.setString(4, cem.getDescription());
				ps.setString(5, cem.getStartDate());
				ps.setString(6, cem.getEndDate());
				return ps;
			}
		});
	}

	@Override
	public Integer updateClientEvent(ClientEventModel cem) {
		String query = "UPDATE business_event SET image_video = ?, title = ?, description = ?, start_date = ?,"
				+ "end_date = ? WHERE event_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, cem.getImageVideo());
				ps.setString(2, cem.getTitle());
				ps.setString(3, cem.getDescription());
				ps.setString(4, cem.getStartDate());
				ps.setString(5, cem.getEndDate());
				ps.setInt(6, cem.getEventId());
				return ps;
			}
		});
	}

	@Override
	public Integer deleteClientEvent(int eventId) {
		String query = "DELETE FROM business_event WHERE event_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, eventId);
				return ps;
			}
		});
	}
	
}
