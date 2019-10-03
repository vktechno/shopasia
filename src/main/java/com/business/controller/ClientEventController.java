package com.business.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.business.model.ClientEventModel;
import com.business.model.ClientOfferModel;
import com.business.service.ClientEventService;
import com.business.service.ClientOfferService;

@RestController
@RequestMapping("/user")
public class ClientEventController {
	
	@Autowired
	ClientEventService clientEventService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getClientEvent", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getClientEventMethod(@RequestBody ClientEventModel cem){
		JSONObject retJs = new JSONObject();
		try {
			List<ClientEventModel> list = clientEventService.getClientEvent(cem.getClientId());
			
			if(!list.isEmpty()){
				retJs.put("status", "1");
				retJs.put("message", "Successfully Get Event");
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
	@RequestMapping(value = "/insertClientEvent", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> insertClientEventMethod(@RequestBody ClientEventModel cem){
		JSONObject retJs = new JSONObject();
		try {
			int returnFlag = clientEventService.insertClientEvent(cem);
			
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
	@RequestMapping(value = "/updateClientEvent", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> updateClientEventMethod(@RequestBody ClientEventModel cem){
		JSONObject retJs = new JSONObject();
		try {
			int returnFlag = clientEventService.updateClientEvent(cem);
			
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
	@RequestMapping(value = "/deleteClientEvent", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> deleteClientEventMethod(@RequestBody ClientEventModel cem){
		JSONObject retJs = new JSONObject();
		try {
			int returnFlag = clientEventService.deleteClientEvent(cem.getEventId());
			
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
