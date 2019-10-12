package com.product.master.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> getCategory() {
		String query = "SELECT cat_id as catId, cat_name as catName FROM product_category";
		return jdbcTemplate.queryForList(query);
	}

	@Override
	public List<Map<String, Object>> getSubCategory(int catId) {
		String query = "SELECT sub_cat_id as subCatId, sub_cat_name as subCatName, cat_id as catId FROM product_sub_category"
				+ " WHERE cat_id = ?";
		return jdbcTemplate.queryForList(query,catId);
	}
	
	
}
