package com.product.master.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.master.dao.CarDao;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	CarDao carDao;
	
	@Override
	public List<Map<String, Object>> getCarBrand() {
		return carDao.getCarBrand();
	}

	@Override
	public Integer insertCarBrand(Map<String, Object> carObject) {
		return carDao.insertCarBrand(carObject);
	}

	@Override
	public Integer updateCarBrand(Map<String, Object> carObject) {
		carObject.put("carId", Integer.parseInt((String) carObject.get("carId")));
		return carDao.updateCarBrand(carObject);
	}

	@Override
	public List<Map<String, Object>> getCarModel() {
		return carDao.getCarBrand();
	}

	@Override
	public Integer insertCarModel(Map<String, Object> carObject) {
		carObject.put("brandId", Integer.parseInt((String)carObject.get("brandId")));
		return carDao.insertCarModel(carObject);
	}

	@Override
	public Integer updateCarModel(Map<String, Object> carObject) {
		carObject.put("modelId", Integer.parseInt((String)carObject.get("modelId")));
		carObject.put("brandId", Integer.parseInt((String)carObject.get("brandId")));
		return carDao.updateCarModel(carObject);
	}

}
