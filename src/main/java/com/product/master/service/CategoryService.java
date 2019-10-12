package com.product.master.service;

import java.util.List;
import java.util.Map;

public interface CategoryService {
	
	List<Map<String, Object>> getCategory();
	List<Map<String, Object>> getSubCategory(int catId);

}
