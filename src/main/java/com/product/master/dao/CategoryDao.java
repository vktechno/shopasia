package com.product.master.dao;

import java.util.List;
import java.util.Map;

public interface CategoryDao {

	List<Map<String, Object>> getCategory();
	List<Map<String, Object>> getSubCategory(int catId);
}
