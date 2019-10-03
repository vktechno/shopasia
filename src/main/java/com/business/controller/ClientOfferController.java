package com.business.controller;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.business.model.ClientOfferModel;
import com.business.model.ClientProductModel;
import com.business.service.ClientOfferService;
import com.business.service.ClientProductService;

@RestController
@RequestMapping("/user")
public class ClientOfferController {
	
	@Autowired
	ClientOfferService clientOfferService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getClientOffer", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getClientOfferMethod(@RequestBody ClientOfferModel com){
		JSONObject retJs = new JSONObject();
		try {
			List<ClientOfferModel> list = clientOfferService.getClientOffer(com.getClientId());
			
			if(!list.isEmpty()){
				retJs.put("status", "1");
				retJs.put("message", "Successfully Get Offer");
				retJs.put("result", list);
			}else{
				retJs.put("status", "0");
				retJs.put("message", "Product not found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			retJs.put("status", "500");
			retJs.put("message", e.getMessage());
			return new ResponseEntity<JSONObject>(retJs, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<JSONObject>(retJs, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertClientOffer", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> insertClientOfferMethod(@RequestBody ClientOfferModel com){
		JSONObject retJs = new JSONObject();
		try {
			int returnFlag = clientOfferService.insertClientOffer(com);
			
			if(returnFlag > 0){
				retJs.put("status", "1");
				retJs.put("message", "Successfully Submited");
			}else{
				retJs.put("status", "0");
				retJs.put("message", "Please Try Again");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			retJs.put("status", "500");
			retJs.put("message", e.getMessage());
			return new ResponseEntity<JSONObject>(retJs, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<JSONObject>(retJs, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/updateClientOffer", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> updateClientOfferMethod(@RequestBody ClientOfferModel com){
		JSONObject retJs = new JSONObject();
		try {
			int returnFlag = clientOfferService.updateClientOffer(com);
			
			if(returnFlag > 0){
				retJs.put("status", "1");
				retJs.put("message", "Successfully Updated");
			}else{
				retJs.put("status", "0");
				retJs.put("message", "Please Try Again");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			retJs.put("status", "500");
			retJs.put("message", e.getMessage());
			return new ResponseEntity<JSONObject>(retJs, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<JSONObject>(retJs, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteClientOffer", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> deleteClientOfferMethod(@RequestBody ClientOfferModel com){
		JSONObject retJs = new JSONObject();
		try {
			int returnFlag = clientOfferService.deleteClientOffer(com.getOfferId());
			
			if(returnFlag > 0){
				retJs.put("status", "1");
				retJs.put("message", "Successfully Deleted");
			}else{
				retJs.put("status", "0");
				retJs.put("message", "Please Try Again");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			retJs.put("status", "500");
			retJs.put("message", e.getMessage());
			return new ResponseEntity<JSONObject>(retJs, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<JSONObject>(retJs, HttpStatus.OK);
	}

}
