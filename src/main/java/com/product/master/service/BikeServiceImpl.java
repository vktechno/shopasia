package com.product.master.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.product.master.dao.BikeDao;

@Service
public class BikeServiceImpl implements BikeService{

	@Autowired
	BikeDao bikeDao;

	@Override
	public List<Map<String, Object>> getBikeBrand() {
		return bikeDao.getBikeBrand();
	}

	@Override
	public Integer insertBikeBrand(Map<String, Object> bikeObject) {
		return bikeDao.insertBikeBrand(bikeObject);
	}

	@Override
	public Integer updateBikeBrand(Map<String, Object> bikeObject) {
		bikeObject.put("brandId", Integer.parseInt((String) bikeObject.get("brandId")));
		return bikeDao.updateBikeBrand(bikeObject);
	}

	@Override
	public List<Map<String, Object>> getBikeModel() {
		return bikeDao.getBikeModel();
	}

	@Override
	public Integer insertBikeModel(Map<String, Object> bikeObject) {
		bikeObject.put("brandId", Integer.parseInt((String) bikeObject.get("brandId")));
		return bikeDao.insertBikeModel(bikeObject);
	}

	@Override
	public Integer updateBikeModel(Map<String, Object> bikeObject) {
		bikeObject.put("brandId", Integer.parseInt((String) bikeObject.get("brandId")));
		bikeObject.put("modelId", Integer.parseInt((String) bikeObject.get("modelId")));
		return bikeDao.updateBikeModel(bikeObject);
	}

	@Override
	public Integer deleteBikeBrand(Map<String, Object> bikeObject) {
		return bikeDao.deleteBikeBrand(bikeObject);
	}

	@Override
	public Integer deleteBikeModel(Map<String, Object> bikeObject) {
		return bikeDao.deleteBikeModel(bikeObject);
	}
}
