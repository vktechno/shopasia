package com.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.dao.CategoryMasterDao;
import com.business.model.CategoryMasterModel;

@Service
public class CategoryMasterServiceImpl implements CategoryMasterService{

	@Autowired
	CategoryMasterDao categoryMasterService;

	@Override
	public List<Map<String, Object>> getCategory() {
		return categoryMasterService.getCategory();
	}

	@Override
	public Integer insertCategory(CategoryMasterModel cmm) {
		return categoryMasterService.insertCategory(cmm);
	}

	@Override
	public Integer updateCategory(CategoryMasterModel cmm) {
		return categoryMasterService.updateCategory(cmm);
	}

	@Override
	public Integer deleteCategory(int catId) {
		return categoryMasterService.deleteCategory(catId);
	}

	@Override
	public List<Map<String, Object>> getSubCategory(int catId) {
		return categoryMasterService.getSubCategory(catId);
	}

	@Override
	public Integer insertSubCategory(CategoryMasterModel cmm) {
		return categoryMasterService.insertSubCategory(cmm);
	}

	@Override
	public Integer updateSubCategory(CategoryMasterModel cmm) {
		return categoryMasterService.updateSubCategory(cmm);
	}

	@Override
	public Integer deleteSubCategory(int subCatId) {
		return categoryMasterService.deleteSubCategory(subCatId);
	}
	
}
