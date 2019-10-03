package com.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.dao.ClientDetailsDao;
import com.business.model.ClientDetailsModel;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService{

	@Autowired
	ClientDetailsDao clientDetailsDao;

	@Override
	public ClientDetailsModel getClientDetails(int ClientId) {
		List<ClientDetailsModel> list = clientDetailsDao.getClientDetails(ClientId);
		ClientDetailsModel cdm = null;
		if(!list.isEmpty()){
			cdm  = list.get(0);
		}
		return cdm;
	}

	@Override
	public Integer insertClientDetails(ClientDetailsModel cdm) {
		return clientDetailsDao.insertClientDetails(cdm);
	}

	@Override
	public Integer updateClientDetails(ClientDetailsModel cdm) {
		return clientDetailsDao.updateClientDetails(cdm);
	}
	
	
	
}
