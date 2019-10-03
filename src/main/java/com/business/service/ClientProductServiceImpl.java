package com.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.dao.ClientProductDao;
import com.business.model.ClientProductModel;

@Service
public class ClientProductServiceImpl implements ClientProductService{

	@Autowired
	ClientProductDao clientProductDao;

	@Override
	public List<Map<String, Object>> getClientProduct(int ClientId) {
		return clientProductDao.getClientProduct(ClientId);
	}

	@Override
	public Integer insertClientProduct(ClientProductModel cdm) {
		return clientProductDao.insertClientProduct(cdm);
	}

	@Override
	public Integer updateClientProduct(ClientProductModel cdm) {
		return clientProductDao.updateClientProduct(cdm);
	}

	@Override
	public Integer deleteClientProduct(int proId) {
		return clientProductDao.deleteClientProduct(proId);
	}
	
}
