package com.product.master.service;

import java.util.List;
import java.util.Map;

public interface BikeService {
	
	List<Map<String, Object>> getBikeBrand();
	Integer insertBikeBrand(Map<String, Object> bikeObject);
	Integer updateBikeBrand(Map<String, Object> bikeObject);
	Integer deleteBikeBrand(Map<String, Object> bikeObject);
	
	List<Map<String, Object>> getBikeModel();
	Integer insertBikeModel(Map<String, Object> bikeObject);
	Integer updateBikeModel(Map<String, Object> bikeObject);
	Integer deleteBikeModel(Map<String, Object> bikeObject);

}
