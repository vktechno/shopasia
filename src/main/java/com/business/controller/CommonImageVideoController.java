package com.business.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletContext;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class CommonImageVideoController {

	@Autowired
	ServletContext context;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/uploadImageVideoCommon", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> uploadImageCommonMethod(@RequestParam("file") MultipartFile file){

		JSONObject js = new JSONObject();
		
		try {
			long fileSize   = file.getSize();
			String fileType = file.getContentType();
			/**
			 * directory created*/
			
			if(fileType.equals("image/png") || fileType.equals("image/jpeg") || fileType.equals("video/mp4") || fileType.equals("video/webm")){
				Random rnd = new Random();
				int randomNumber = 100000 + rnd.nextInt(900000);
				
				String absoluteFilePath = context.getRealPath("/");
				File path1 = new File(absoluteFilePath+"/uploaded-image");
				if(!path1.exists()){
					boolean createDir = path1.mkdir();
					System.out.println("directory created "+createDir);
				}
				
				String fileName = randomNumber+"-"+file.getOriginalFilename();
				File uploadedFile = new File(path1 ,fileName);
				
				
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
	            stream.write(file.getBytes());
	            stream.close();
				
				js.put("status", "1");
				js.put("message", "successfully submited");
				js.put("imageName", fileName);
			}else{
				js.put("status", "0");
				js.put("message", "Please Upload image jpg, png And video Mp4, webm");
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			js.put("status", "500");
			js.put("message", e.getMessage());
			return new ResponseEntity<JSONObject>(js, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
		
	
		
	}
}
