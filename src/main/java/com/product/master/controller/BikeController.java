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

import com.product.master.service.BikeService;

@RestController
@RequestMapping("/admin")
public class BikeController {

	@Autowired
	BikeService bikeService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getBikeBrandMaster", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getgetBikeBrandMasterMethod(){
		JSONObject js = new JSONObject();
		try {
			List<Map<String, Object>> list = bikeService.getBikeBrand();
			if(!list.isEmpty()){
				js.put("status", "1");
				js.put("message", "Get All Bike Brands");
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
	@RequestMapping(value = "/insertBikeBrandMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getInsertBikeBrandMasterMethod(@RequestBody JSONObject bikeObject){
		JSONObject js = new JSONObject();
		try {
			int flag = bikeService.insertBikeBrand(bikeObject);
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
	@RequestMapping(value = "/updateBikeBrandMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getUpdateCarBrandMasterMethod(@RequestBody Map<String, Object> bikeObject){
		JSONObject js = new JSONObject();
		try {
			int flag = bikeService.updateBikeBrand(bikeObject);
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
	@RequestMapping(value = "/getBikeModelMaster", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getGetBikeModelMasterMethod(){
		JSONObject js = new JSONObject();
		try {
			List<Map<String, Object>> list = bikeService.getBikeModel();
			if(!list.isEmpty()){
				js.put("status", "1");
				js.put("message", "Get All Bike Brands");
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
	@RequestMapping(value = "/insertBikeModelMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getInsertBikeModelMasterMethod(@RequestBody JSONObject bikeObject){
		JSONObject js = new JSONObject();
		try {
			int flag = bikeService.insertBikeModel(bikeObject);
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
	@RequestMapping(value = "/updateBikeModelMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getUpdateBikeModelMasterMethod(@RequestBody Map<String, Object> bikeObject){
		JSONObject js = new JSONObject();
		try {
			int flag = bikeService.updateBikeModel(bikeObject);
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
	@RequestMapping(value = "/deleteBikeModelMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getDeleteBikeModelMasterMethod(@RequestBody Map<String, Object> bikeObject){
		JSONObject js = new JSONObject();
		try {
			int flag = bikeService.deleteBikeModel(bikeObject);
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
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteBikeBrandMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getDeleteBikeBrandMasterMethod(@RequestBody Map<String, Object> bikeObject){
		JSONObject js = new JSONObject();
		try {
			int flag = bikeService.deleteBikeBrand(bikeObject);
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
