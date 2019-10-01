package com.product.details.service;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.details.dao.ProductDao;
import com.product.details.model.ProductModel;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;

	@Override
	public List<Map<String, Object>> getMobileProduct(JSONObject jsonObject) {
		return productDao.getMobileProduct(jsonObject);
	}

	@Override
	public Integer insertMobileProduct(ProductModel pm) {
		return productDao.insertMobileProduct(pm);
	}

	@Override
	public Integer updateMobileProduct(ProductModel pm) {
		return productDao.updateMobileProduct(pm);
	}

	@Override
	public Integer deleteMobileProduct(ProductModel pm) {
		return productDao.deleteMobileProduct(pm);
	}

	@Override
	public Integer insertImage(int productId, String imageName) {
		return productDao.insertImage(productId, imageName);
	}

	@Override
	public Integer deleteImage(int productId) {
		return productDao.deleteImage(productId);
	}

	@Override
	public List<Map<String, Object>> getImage(int productId) {
		return productDao.getImage(productId);
	}
}
