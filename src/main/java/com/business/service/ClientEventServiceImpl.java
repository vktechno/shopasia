package com.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.dao.ClientEventDao;
import com.business.model.ClientEventModel;

@Service
public class ClientEventServiceImpl implements ClientEventService{

	@Autowired
	ClientEventDao clientEventDao;

	@Override
	public List<ClientEventModel> getClientEvent(int ClientId) {
		return clientEventDao.getClientEvent(ClientId);
	}

	@Override
	public Integer insertClientEvent(ClientEventModel cem) {
		return clientEventDao.insertClientEvent(cem);
	}

	@Override
	public Integer updateClientEvent(ClientEventModel cem) {
		return clientEventDao.updateClientEvent(cem);
	}

	@Override
	public Integer deleteClientEvent(int eventId) {
		return clientEventDao.deleteClientEvent(eventId);
	}
	
}
