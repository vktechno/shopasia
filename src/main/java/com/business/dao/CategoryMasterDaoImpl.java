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

import com.business.model.CategoryMasterModel;

@Repository
public class CategoryMasterDaoImpl implements CategoryMasterDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> getCategory() {
		String query = "SELECT cat_id as catId, cat_name as category FROM business_category";
		return jdbcTemplate.queryForList(query);
	}

	@Override
	public Integer insertCategory(CategoryMasterModel cmm) {
		String query = "INSERT INTO business_category(cat_name) values(?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, cmm.getCategory());
				return ps;
			}
		});
	}

	@Override
	public Integer updateCategory(CategoryMasterModel cmm) {
		String query = "UPDATE business_category SET cat_name = ? WHERE cat_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, cmm.getCategory());
				ps.setInt(2, cmm.getCatId());
				return ps;
			}
		});
	}

	@Override
	public Integer deleteCategory(int catId) {
		String query = "DELETE FROM business_category WHERE cat_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, catId);
				return ps;
			}
		});
	}

	@Override
	public List<Map<String, Object>> getSubCategory(int catId) {
		String query = "SELECT sub_cat_id as subCatId, sub_cat_name as subCategory FROM business_sub_category"
				+ " WHERE cat_id = ?";
		return jdbcTemplate.queryForList(query, catId);
	}

	@Override
	public Integer insertSubCategory(CategoryMasterModel cmm) {
		String query = "INSERT INTO business_sub_category(sub_cat_name, cat_id) values(?,?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, cmm.getSubCategory());
				ps.setInt(2, cmm.getCatId());
				return ps;
			}
		});
	}

	@Override
	public Integer updateSubCategory(CategoryMasterModel cmm) {
		String query = "UPDATE business_sub_category set sub_cat_name = ?, cat_id = ? WHERE sub_cat_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, cmm.getSubCategory());
				ps.setInt(2, cmm.getCatId());
				ps.setInt(3, cmm.getSubCatId());
				return ps;
			}
		});
	}

	@Override
	public Integer deleteSubCategory(int subCatId) {
		String query = "DELETE FROM business_sub_category WHERE sub_cat_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, subCatId);
				return ps;
			}
		});
	}
	
	
}
