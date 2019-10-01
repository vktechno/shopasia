package com.product.master.service;

import java.util.List;
import java.util.Map;

public interface MobileBrandService {

	List<Map<String, Object>> getMobileBrand();
	Integer insertMobileBrand(Map<String, Object> mobileObject);
	Integer updateMobileBrand(Map<String, Object> mobileObject);
	Integer deleteMobileBrand(Map<String, Object> mobileObject);
}
