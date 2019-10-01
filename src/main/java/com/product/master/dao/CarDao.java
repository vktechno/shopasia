package com.product.master.dao;

import java.util.List;
import java.util.Map;

public interface CarDao {
	
	List<Map<String, Object>> getCarBrand();
	Integer insertCarBrand(Map<String, Object> carObject);
	Integer updateCarBrand(Map<String, Object> carObject);
	Integer deleteCarBrand(Map<String, Object> carObject);
	
	List<Map<String, Object>> getCarModel();
	Integer insertCarModel(Map<String, Object> carObject);
	Integer updateCarModel(Map<String, Object> carObject);
	Integer deleteCarModel(Map<String, Object> carObject);
	
	
}
