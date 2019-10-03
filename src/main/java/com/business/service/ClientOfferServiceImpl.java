package com.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.dao.ClientOfferDao;
import com.business.model.ClientOfferModel;

@Service
public class ClientOfferServiceImpl implements ClientOfferService{

	@Autowired
	ClientOfferDao clientOfferDao;

	@Override
	public List<ClientOfferModel> getClientOffer(int ClientId) {
		return clientOfferDao.getClientOffer(ClientId);
	}

	@Override
	public Integer insertClientOffer(ClientOfferModel com) {
		return clientOfferDao.insertClientOffer(com);
	}

	@Override
	public Integer updateClientOffer(ClientOfferModel com) {
		return clientOfferDao.updateClientOffer(com);
	}

	@Override
	public Integer deleteClientOffer(int offerId) {
		return clientOfferDao.deleteClientOffer(offerId);
	}
	
	
}
