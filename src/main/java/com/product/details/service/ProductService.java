package com.product.details.service;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.product.details.model.ProductModel;
import com.product.details.model.RealEstateModel;

public interface ProductService {
	
	/**
	 * common image
	 */
	Integer insertImage(int productId, String imageName);
	Integer deleteImage(int productId);
	List<Map<String, Object>> getImage(int productId);
	
	/**
	 * common delete product
	 */
	Integer deleteMobileProduct(ProductModel pm);
	
	/**
	 * mobile
	 */
	List<Map<String, Object>> getMobileProduct(JSONObject jsonObject);
	Integer insertMobileProduct(ProductModel pm);
	Integer updateMobileProduct(ProductModel pm);
	
	
	/**
	 * tablet
	 */
	List<Map<String, Object>> getTabletProduct(JSONObject jsonObject);
	Integer insertTabletProduct(ProductModel pm);
	Integer updateTabletProduct(ProductModel pm);
	
	/**
	 * Accessories
	 */
	List<Map<String, Object>> getAcceProduct(JSONObject jsonObject);
	Integer insertAcceProduct(ProductModel pm);
	Integer updateAcceProduct(ProductModel pm);
	
	/**
	 * Furniture
	 */
	List<Map<String, Object>> getFurnProduct(JSONObject jsonObject);
	Integer insertFurnProduct(ProductModel pm);
	Integer updateFurnProduct(ProductModel pm);
	
	/**
	 * bikes -> Motorcycles, scooter
	 */
	List<Map<String, Object>> getMotorcycleProduct(JSONObject jsonObject);
	Integer insertMotorcycleProduct(ProductModel pm);
	Integer updateMotorcycleProduct(ProductModel pm);
	
	/**
	 * real estate
	 */
	
	List<RealEstateModel> getRealEstateProdut();
	Integer insertRealEstateProduct(RealEstateModel rem);
	Integer updateRealEstateProduct(RealEstateModel rem);
	
	/**
	 * common get product
	 */
	List<ProductModel> getCommonProductDetails(Map<String, Object> map);

}
