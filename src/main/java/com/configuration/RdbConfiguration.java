package com.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com")
public class RdbConfiguration extends WebMvcConfigurerAdapter{
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
	    return new JdbcTemplate(getDataSource());
	}
	
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		/*ds.setUrl("jdbc:mysql://rdbpayrolldbs.cbuqy1rjms3q.ap-south-1.rds.amazonaws.com:3306/rdbpayrolldatabase");
		ds.setUsername("rdbpayrolladmin");
		ds.setPassword("rdbpassword");*/
		
		ds.setUrl("jdbc:mysql://localhost:3306/rdb_olx");
		ds.setUsername("root");
		ds.setPassword("");

		return ds;
	}
	
	@Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
	
	 @Bean
	 public ViewResolver view(){
		 InternalResourceViewResolver view = new InternalResourceViewResolver();
		 view.setPrefix("/");
		 view.setSuffix(".html");
		 return view;
	 }
	 
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/**").addResourceLocations("/");
	    }
	    
}
