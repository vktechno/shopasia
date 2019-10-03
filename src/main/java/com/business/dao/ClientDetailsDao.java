package com.business.dao;

import java.util.List;

import com.business.model.ClientDetailsModel;

public interface ClientDetailsDao {

	/**
	 * client
	 */
	List<ClientDetailsModel> getClientDetails(int ClientId);
	Integer insertClientDetails(ClientDetailsModel cdm);
	Integer updateClientDetails(ClientDetailsModel cdm);
	
}
