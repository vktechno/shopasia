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

import com.product.master.service.CarService;

@RestController
public class CarController {
	
	@Autowired
	CarService carService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getCarBrandMaster", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getgetCarBrandMasterMethod(){
		JSONObject js = new JSONObject();
		try {
			List<Map<String, Object>> list = carService.getCarBrand();
			if(!list.isEmpty()){
				js.put("status", "1");
				js.put("message", "Get All Car Brands");
				js.put("result", list);
			}else{
				js.put("status", "0");
				js.put("message", "Category Not Found");
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
	@RequestMapping(value = "/insertCarBrandMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getInsertCarBrandMasterMethod(@RequestBody JSONObject carObject){
		JSONObject js = new JSONObject();
		try {
			int flag = carService.insertCarBrand(carObject);
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
	@RequestMapping(value = "/updateCarBrandMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getUpdateCarBrandMasterMethod(@RequestBody Map<String, Object> carObject){
		JSONObject js = new JSONObject();
		try {
			int flag = carService.updateCarBrand(carObject);
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
	@RequestMapping(value = "/getCarModelMaster", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getGetCarModelMasterMethod(){
		JSONObject js = new JSONObject();
		try {
			List<Map<String, Object>> list = carService.getCarModel();
			if(!list.isEmpty()){
				js.put("status", "1");
				js.put("message", "Get All Car Brands");
				js.put("result", list);
			}else{
				js.put("status", "0");
				js.put("message", "Category Not Found");
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
	@RequestMapping(value = "/insertCarModelMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getInsertCarModelMasterMethod(@RequestBody JSONObject carObject){
		JSONObject js = new JSONObject();
		try {
			int flag = carService.insertCarModel(carObject);
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
	@RequestMapping(value = "/updateCarModelMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getUpdateCarModelMasterMethod(@RequestBody Map<String, Object> carObject){
		JSONObject js = new JSONObject();
		try {
			int flag = carService.updateCarModel(carObject);
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

}
