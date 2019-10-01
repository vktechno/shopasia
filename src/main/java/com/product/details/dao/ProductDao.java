package com.product.details.dao;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.product.details.model.ProductModel;

public interface ProductDao {

	/**
	 * common image
	 */
	Integer insertImage(int productId, String imageName);
	Integer deleteImage(int productId);
	List<Map<String, Object>> getImage(int productId);
	
	
	/**
	 * mobile
	 */
	List<Map<String, Object>> getMobileProduct(JSONObject jsonObject);
	Integer insertMobileProduct(ProductModel pm);
	Integer updateMobileProduct(ProductModel pm);
	Integer deleteMobileProduct(ProductModel pm);
}
