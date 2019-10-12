package com.product.details.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.details.model.ProductModel;
import com.product.details.model.RealEstateModel;
import com.product.details.service.ProductService;

@RestController
@RequestMapping("/admin")
public class AdminRealEstateController {

	@Autowired
	ProductService productService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertRealEstateProduct", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> insertRealEstateMethod(@RequestBody RealEstateModel rem){
		JSONObject retJs = new JSONObject();
		try {
			
			int insertFlag = productService.insertRealEstateProduct(rem);
			if(insertFlag > 0){
				
				List<String> imageNames = rem.getImageNames();
				if(!imageNames.isEmpty()){
					for(String img : imageNames){
						int imageFlag = productService.insertImage(insertFlag, img);
					}
				}
				
				retJs.put("status", "1");
				retJs.put("message", "Successfully Submited");
				
			}else{
				retJs.put("status", "0");
				retJs.put("message", "Please Try Again !");
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
	@RequestMapping(value = "/updateRealEstateProduct", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> updateRealEstateMethod(@RequestBody RealEstateModel rem){
		JSONObject retJs = new JSONObject();
		try {
			
			int insertFlag = productService.updateRealEstateProduct(rem);
			if(insertFlag > 0){
				
				int delImgFlag = productService.deleteImage(rem.getProductId());
				
				if(delImgFlag > 0){
					List<String> imageNames = rem.getImageNames();
					if(!imageNames.isEmpty()){
						for(String img : imageNames){
							int imageFlag = productService.insertImage(rem.getProductId(), img);
						}
					}
				}
				
				retJs.put("status", "1");
				retJs.put("message", "Successfully Updated");
				
			}else{
				retJs.put("status", "0");
				retJs.put("message", "Please Try Again !");
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
