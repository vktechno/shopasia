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
import com.product.details.service.ProductService;

@RestController
@RequestMapping("/admin")
public class AdminMobileController {
	
	@Autowired
	ProductService productService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertMobileProduct", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> insertMobileProductMethod(@RequestBody ProductModel pm){
		JSONObject retJs = new JSONObject();
		try {
			
			int insertFlag = productService.insertMobileProduct(pm);
			if(insertFlag > 0){
				
				List<String> imageNames = pm.getImageNames();
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
	@RequestMapping(value = "/updateMobileProduct", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> updateMobileProductMethod(@RequestBody ProductModel pm){
		JSONObject retJs = new JSONObject();
		try {
			
			int insertFlag = productService.updateMobileProduct(pm);
			if(insertFlag > 0){
				
				int delImgFlag = productService.deleteImage(pm.getProductId());
				
				if(delImgFlag > 0){
					List<String> imageNames = pm.getImageNames();
					if(!imageNames.isEmpty()){
						for(String img : imageNames){
							int imageFlag = productService.insertImage(pm.getProductId(), img);
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
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteMobileProduct", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> deleteMobileProductMethod(@RequestBody ProductModel pm){
		JSONObject retJs = new JSONObject();
		try {
			
			int insertFlag = productService.deleteMobileProduct(pm);
			if(insertFlag > 0){
				
				int delImgFlag = productService.deleteImage(pm.getProductId());
				
				retJs.put("status", "1");
				retJs.put("message", "Successfully Deleted");
				
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
	@RequestMapping(value = "/insertTabletProduct", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> insertTabletProductMethod(@RequestBody ProductModel pm){
		JSONObject retJs = new JSONObject();
		try {
			
			int insertFlag = productService.insertTabletProduct(pm);
			if(insertFlag > 0){
				
				List<String> imageNames = pm.getImageNames();
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
	@RequestMapping(value = "/updateTabletProduct", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> updateTabletProductMethod(@RequestBody ProductModel pm){
		JSONObject retJs = new JSONObject();
		try {
			
			int insertFlag = productService.updateTabletProduct(pm);
			if(insertFlag > 0){
				
				int delImgFlag = productService.deleteImage(pm.getProductId());
				
				if(delImgFlag > 0){
					List<String> imageNames = pm.getImageNames();
					if(!imageNames.isEmpty()){
						for(String img : imageNames){
							int imageFlag = productService.insertImage(pm.getProductId(), img);
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
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertAcceProduct", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> insertAcceProductMethod(@RequestBody ProductModel pm){
		JSONObject retJs = new JSONObject();
		try {
			
			int insertFlag = productService.insertAcceProduct(pm);
			if(insertFlag > 0){
				
				List<String> imageNames = pm.getImageNames();
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
	@RequestMapping(value = "/updateAcceProduct", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> updateAcceProductMethod(@RequestBody ProductModel pm){
		JSONObject retJs = new JSONObject();
		try {
			
			int insertFlag = productService.updateAcceProduct(pm);
			if(insertFlag > 0){
				
				int delImgFlag = productService.deleteImage(pm.getProductId());
				
				if(delImgFlag > 0){
					List<String> imageNames = pm.getImageNames();
					if(!imageNames.isEmpty()){
						for(String img : imageNames){
							int imageFlag = productService.insertImage(pm.getProductId(), img);
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
