package com.product.master.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.master.dao.MobileDaoBrand;

@Service
public class MobileBrandServiceImpl implements MobileBrandService{

	@Autowired
	MobileDaoBrand mobileDaoBrand;
	
	
	@Override
	public List<Map<String, Object>> getMobileBrand() {
		return mobileDaoBrand.getMobileBrand();
	}

	@Override
	public Integer insertMobileBrand(Map<String, Object> mobileObject) {
		return mobileDaoBrand.insertMobileBrand(mobileObject);
	}

	@Override
	public Integer updateMobileBrand(Map<String, Object> mobileObject) {
		return mobileDaoBrand.updateMobileBrand(mobileObject);
	}

	@Override
	public Integer deleteMobileBrand(Map<String, Object> mobileObject) {
		return mobileDaoBrand.deleteMobileBrand(mobileObject);
	}

}
