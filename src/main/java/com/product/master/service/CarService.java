package com.product.master.service;

import java.util.List;
import java.util.Map;

public interface CarService {

	List<Map<String, Object>> getCarBrand();
	Integer insertCarBrand(Map<String, Object> carObject);
	Integer updateCarBrand(Map<String, Object> carObject);
	
	List<Map<String, Object>> getCarModel();
	Integer insertCarModel(Map<String, Object> carObject);
	Integer updateCarModel(Map<String, Object> carObject);
}
