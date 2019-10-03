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

import com.business.model.ClientDetailsModel;
import com.business.model.ClientProductModel;
import com.business.service.ClientProductService;

@RestController
@RequestMapping("/user")
public class ClientProductController {
	
	@Autowired
	ClientProductService clientProductService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getClientProduct", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getClientProductMethod(@RequestBody ClientProductModel cpm){
		JSONObject retJs = new JSONObject();
		try {
			List<Map<String, Object>> list = clientProductService.getClientProduct(cpm.getClientId());
			
			if(!list.isEmpty()){
				retJs.put("status", "1");
				retJs.put("message", "Successfully Get Product");
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
	@RequestMapping(value = "/insertClientProduct", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> insertClientProductMethod(@RequestBody ClientProductModel cpm){
		JSONObject retJs = new JSONObject();
		try {
			int returnFlag = clientProductService.insertClientProduct(cpm);
			
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
	@RequestMapping(value = "/updateClientProduct", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> updateClientProductMethod(@RequestBody ClientProductModel cpm){
		JSONObject retJs = new JSONObject();
		try {
			int returnFlag = clientProductService.updateClientProduct(cpm);
			
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
	@RequestMapping(value = "/deleteClientProduct", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> deleteClientProductMethod(@RequestBody ClientProductModel cpm){
		JSONObject retJs = new JSONObject();
		try {
			int returnFlag = clientProductService.deleteClientProduct(cpm.getProId());
			
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
