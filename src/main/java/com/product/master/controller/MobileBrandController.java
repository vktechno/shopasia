package com.product.master.controller;

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

import com.product.master.service.MobileBrandService;

@RestController
@RequestMapping("/admin")
public class MobileBrandController {

	@Autowired
	MobileBrandService mobileBrandService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getMobileBrandMaster", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getMobileBrandMasterMethod(){
		JSONObject js = new JSONObject();
		try {
			List<Map<String, Object>> list = mobileBrandService.getMobileBrand();
			if(!list.isEmpty()){
				js.put("status", "1");
				js.put("message", "Get All Mobile Brands");
				js.put("result", list);
			}else{
				js.put("status", "0");
				js.put("message", "Mobile Not Found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			js.put("status", "500");
			js.put("message", e.getMessage());
			return new ResponseEntity<JSONObject>(js, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertMobileBrandMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getInsertMobileBrandMasterMethod(@RequestBody JSONObject mobileObject){
		JSONObject js = new JSONObject();
		try {
			int flag = mobileBrandService.insertMobileBrand(mobileObject);
			if(flag > 0){
				js.put("status", "1");
				js.put("message", "Successfully Submitted");
			}else{
				js.put("status", "0");
				js.put("message", "Please Try Again");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			js.put("status", "500");
			js.put("message", e.getMessage());
			return new ResponseEntity<JSONObject>(js, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/updateMobileBrandMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> updateMobileBrandMasterMethod(@RequestBody JSONObject mobileObject){
		JSONObject js = new JSONObject();
		try {
			int flag = mobileBrandService.updateMobileBrand(mobileObject);
			if(flag > 0){
				js.put("status", "1");
				js.put("message", "Successfully Updated");
			}else{
				js.put("status", "0");
				js.put("message", "Please Try Again");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			js.put("status", "500");
			js.put("message", e.getMessage());
			return new ResponseEntity<JSONObject>(js, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteMobileBrandMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> deleteMobileBrandMasterMethod(@RequestBody JSONObject mobileObject){
		JSONObject js = new JSONObject();
		try {
			int flag = mobileBrandService.deleteMobileBrand(mobileObject);
			if(flag > 0){
				js.put("status", "1");
				js.put("message", "Successfully Deleted");
			}else{
				js.put("status", "0");
				js.put("message", "Please Try Again");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			js.put("status", "500");
			js.put("message", e.getMessage());
			return new ResponseEntity<JSONObject>(js, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
		
	}
}
