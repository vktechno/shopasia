package com.business.service;

import java.util.List;

import com.business.model.ClientOfferModel;

public interface ClientOfferService {

	/**
	 * client
	 */
	List<ClientOfferModel> getClientOffer(int ClientId);
	Integer insertClientOffer(ClientOfferModel com);
	Integer updateClientOffer(ClientOfferModel com);
	Integer deleteClientOffer(int offerId);
}
