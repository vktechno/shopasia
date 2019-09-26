package com.configuration;


import java.io.File;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class RdbInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 MB
	 @Override
	    protected Class<?>[] getRootConfigClasses() {
	        return new Class[] { RdbConfiguration.class };
	    }
	   
	    @Override
	    protected Class<?>[] getServletConfigClasses() {
	        return null;
	    }
	   
	    @Override
	    protected String[] getServletMappings() {
	    	System.out.println("running");
	        return new String[] { "/" };
	    }
	     
	    @Override
	    protected Filter[] getServletFilters() {
	        Filter [] singleton = { new CORSFilter() };
	        return singleton;
	    }
	    
	    @Override
	    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

	        // upload temp file will put here
	        File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));

	        // register a MultipartConfigElement
	        MultipartConfigElement multipartConfigElement =
	                new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
	                        maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);

	        registration.setMultipartConfig(multipartConfigElement);

	    }
}
