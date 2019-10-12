package com.product.details.service;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.details.dao.ProductDao;
import com.product.details.model.ProductModel;
import com.product.details.model.RealEstateModel;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;

	@Override
	public List<Map<String, Object>> getMobileProduct(JSONObject jsonObject) {
		return productDao.getMobileProduct(jsonObject);
	}

	@Override
	public Integer insertMobileProduct(ProductModel pm) {
		return productDao.insertMobileProduct(pm);
	}

	@Override
	public Integer updateMobileProduct(ProductModel pm) {
		return productDao.updateMobileProduct(pm);
	}

	@Override
	public Integer deleteMobileProduct(ProductModel pm) {
		return productDao.deleteMobileProduct(pm);
	}

	@Override
	public Integer insertImage(int productId, String imageName) {
		return productDao.insertImage(productId, imageName);
	}

	@Override
	public Integer deleteImage(int productId) {
		return productDao.deleteImage(productId);
	}

	@Override
	public List<Map<String, Object>> getImage(int productId) {
		return productDao.getImage(productId);
	}

	@Override
	public List<Map<String, Object>> getTabletProduct(JSONObject jsonObject) {
		return productDao.getTabletProduct(jsonObject);
	}

	@Override
	public Integer insertTabletProduct(ProductModel pm) {
		return productDao.insertTabletProduct(pm);
	}

	@Override
	public Integer updateTabletProduct(ProductModel pm) {
		return productDao.updateTabletProduct(pm);
	}

	@Override
	public List<Map<String, Object>> getAcceProduct(JSONObject jsonObject) {
		return productDao.getAcceProduct(jsonObject);
	}

	@Override
	public Integer insertAcceProduct(ProductModel pm) {
		return productDao.insertAcceProduct(pm);
	}

	@Override
	public Integer updateAcceProduct(ProductModel pm) {
		return productDao.updateAcceProduct(pm);
	}

	@Override
	public List<Map<String, Object>> getFurnProduct(JSONObject jsonObject) {
		return productDao.getFurnProduct(jsonObject);
	}

	@Override
	public Integer insertFurnProduct(ProductModel pm) {
		return productDao.insertFurnProduct(pm);
	}

	@Override
	public Integer updateFurnProduct(ProductModel pm) {
		return productDao.updateFurnProduct(pm);
	}

	@Override
	public List<Map<String, Object>> getMotorcycleProduct(JSONObject jsonObject) {
		return productDao.getMotorcycleProduct(jsonObject);
	}

	@Override
	public Integer insertMotorcycleProduct(ProductModel pm) {
		return productDao.insertMotorcycleProduct(pm);
	}

	@Override
	public Integer updateMotorcycleProduct(ProductModel pm) {
		return productDao.updateMotorcycleProduct(pm);
	}

	@Override
	public List<RealEstateModel> getRealEstateProdut() {
		return productDao.getRealEstateProdut();
	}

	@Override
	public Integer insertRealEstateProduct(RealEstateModel rem) {
		return productDao.insertRealEstateProduct(rem);
	}

	@Override
	public Integer updateRealEstateProduct(RealEstateModel rem) {
		return productDao.updateRealEstateProduct(rem);
	}
}
