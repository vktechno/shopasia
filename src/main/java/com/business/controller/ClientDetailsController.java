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

import com.business.model.CategoryMasterModel;
import com.business.model.ClientDetailsModel;
import com.business.service.ClientDetailsService;

@RestController
@RequestMapping("/user")
public class ClientDetailsController {
	
	@Autowired
	ClientDetailsService clientDetailsService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getClientDetails", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getClientDetailsMethod(@RequestBody ClientDetailsModel cdm){
		JSONObject retJs = new JSONObject();
		try {
			ClientDetailsModel cdmRet = clientDetailsService.getClientDetails(cdm.getClientId());
			
			if(cdmRet.getEmail() != null){
				retJs.put("status", "1");
				retJs.put("message", "Successfully Get Client");
				retJs.put("result", cdmRet);
			}else{
				retJs.put("status", "0");
				retJs.put("message", "C;lient not found");
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
	@RequestMapping(value = "/insertClientDetails", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> insertClientDetailsMethod(@RequestBody ClientDetailsModel cdm){
		JSONObject retJs = new JSONObject();
		try {
			int returnFlag = clientDetailsService.insertClientDetails(cdm);
			
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
	@RequestMapping(value = "/updateClientDetails", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> updateClientDetailsMethod(@RequestBody ClientDetailsModel cdm){
		JSONObject retJs = new JSONObject();
		try {
			int returnFlag = clientDetailsService.updateClientDetails(cdm);
			
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

}
