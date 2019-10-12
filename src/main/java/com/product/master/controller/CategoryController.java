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

import com.product.master.service.CategoryService;

@RestController
@RequestMapping("/admin")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/productCategory", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getProductCategoryMethod(){
		JSONObject js = new JSONObject();
		try {
			List<Map<String, Object>> list = categoryService.getCategory();
			if(!list.isEmpty()){
				js.put("status", "1");
				js.put("message", "Get All Product Category");
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
	@RequestMapping(value = "/productSubCategory", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getProductSubCategoryMethod(@RequestBody JSONObject jsReq){
		JSONObject js = new JSONObject();
		try {
			int catId = Integer.parseInt((String) jsReq.get("catId"));
			List<Map<String, Object>> list = categoryService.getSubCategory(catId);
			if(!list.isEmpty()){
				js.put("status", "1");
				js.put("message", "Get All Product Sub Category");
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

}
