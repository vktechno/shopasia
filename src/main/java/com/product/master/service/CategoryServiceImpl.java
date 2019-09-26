package com.product.master.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.master.dao.CategoryDao;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public List<Map<String, Object>> getCategory() {
		return categoryDao.getCategory();
	}

}
