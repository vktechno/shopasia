package com.business.service;

import com.business.model.ClientDetailsModel;

public interface ClientDetailsService {

	/**
	 * client
	 */
	ClientDetailsModel getClientDetails(int ClientId);
	Integer insertClientDetails(ClientDetailsModel cdm);
	Integer updateClientDetails(ClientDetailsModel cdm);
}
