package com.business.service;

import java.util.List;
import java.util.Map;

import com.business.model.CategoryMasterModel;

public interface CategoryMasterService {

	/**
	 * category*/
	List<Map<String, Object>> getCategory();
	Integer insertCategory(CategoryMasterModel cmm);
	Integer updateCategory(CategoryMasterModel cmm);
	Integer deleteCategory(int catId);
	
	/**
	 * sub category*/
	List<Map<String, Object>> getSubCategory(int catId);
	Integer insertSubCategory(CategoryMasterModel cmm);
	Integer updateSubCategory(CategoryMasterModel cmm);
	Integer deleteSubCategory(int subCatId);
}
