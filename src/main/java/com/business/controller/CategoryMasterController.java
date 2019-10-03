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
import com.business.service.CategoryMasterService;

@RestController
@RequestMapping("/admin")
public class CategoryMasterController {

	@Autowired
	CategoryMasterService categoryMasterService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getBusinessCategoryMaster", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getBusinessCategoryMasterMethod(){
		JSONObject retJs = new JSONObject();
		try {
			List<Map<String, Object>> list = categoryMasterService.getCategory();
			
			if(!list.isEmpty()){
				retJs.put("status", "1");
				retJs.put("message", "Successfully Get All Category");
				retJs.put("result", list);
			}else{
				retJs.put("status", "0");
				retJs.put("message", "Category not found");
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
	@RequestMapping(value = "/insertBusinessCategoryMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> insertBusinessCategoryMasterMethod(@RequestBody CategoryMasterModel cmm){
		JSONObject retJs = new JSONObject();
		try {
			int returnFlag = categoryMasterService.insertCategory(cmm);
			
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
	@RequestMapping(value = "/updateBusinessCategoryMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> updateBusinessCategoryMasterMethod(@RequestBody CategoryMasterModel cmm){
		JSONObject retJs = new JSONObject();
		try {
			int returnFlag = categoryMasterService.updateCategory(cmm);
			
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
	@RequestMapping(value = "/deleteBusinessCategoryMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> deleteBusinessCategoryMasterMethod(@RequestBody CategoryMasterModel cmm){
		JSONObject retJs = new JSONObject();
		try {
			int returnFlag = categoryMasterService.deleteCategory(cmm.getCatId());
			
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
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getBusinessSubCategoryMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getSubBusinessCategoryMasterMethod(@RequestBody CategoryMasterModel cmm){
		JSONObject retJs = new JSONObject();
		try {
			List<Map<String, Object>> list = categoryMasterService.getSubCategory(cmm.getCatId());
			
			if(!list.isEmpty()){
				retJs.put("status", "1");
				retJs.put("message", "Successfully Get Sub Category");
				retJs.put("result", list);
			}else{
				retJs.put("status", "0");
				retJs.put("message", "Category not found");
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
	@RequestMapping(value = "/insertBusinessSubCategoryMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> insertBusinessSubCategoryMasterMethod(@RequestBody CategoryMasterModel cmm){
		JSONObject retJs = new JSONObject();
		try {
			int returnFlag = categoryMasterService.insertSubCategory(cmm);
			
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
	@RequestMapping(value = "/updateBusinessSubCategoryMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> updateBusinessSubCategoryMasterMethod(@RequestBody CategoryMasterModel cmm){
		JSONObject retJs = new JSONObject();
		try {
			int returnFlag = categoryMasterService.updateSubCategory(cmm);
			
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
	@RequestMapping(value = "/deleteBusinessSubCategoryMaster", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> deleteBusinessSubCategoryMasterMethod(@RequestBody CategoryMasterModel cmm){
		JSONObject retJs = new JSONObject();
		try {
			int returnFlag = categoryMasterService.deleteSubCategory(cmm.getSubCatId());
			
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
