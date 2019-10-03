package com.business.service;

import java.util.List;

import com.business.model.ClientEventModel;

public interface ClientEventService {

	/**
	 * client
	 */
	List<ClientEventModel> getClientEvent(int ClientId);
	Integer insertClientEvent(ClientEventModel cem);
	Integer updateClientEvent(ClientEventModel cem);
	Integer deleteClientEvent(int eventId);
}
