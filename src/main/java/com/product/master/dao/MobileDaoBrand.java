package com.product.master.dao;

import java.util.List;
import java.util.Map;

public interface MobileDaoBrand {

	List<Map<String, Object>> getMobileBrand();
	Integer insertMobileBrand(Map<String, Object> mobileObject);
	Integer updateMobileBrand(Map<String, Object> mobileObject);
	Integer deleteMobileBrand(Map<String, Object> mobileObject);
}
