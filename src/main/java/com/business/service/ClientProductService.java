package com.business.service;

import java.util.List;
import java.util.Map;

import com.business.model.ClientProductModel;

public interface ClientProductService {

	/**
	 * client
	 */
	List<Map<String, Object>> getClientProduct(int ClientId);
	Integer insertClientProduct(ClientProductModel cdm);
	Integer updateClientProduct(ClientProductModel cdm);
	Integer deleteClientProduct(int proId);
}
