package com.happy.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
/**
 * 
 * @author Administrator
 * @serial swagger练习
 */
@Configuration
@EnableWebMvc
@EnableSwagger
@ComponentScan(basePackages="com.happy.controller.like")
public class SwaggerPluginConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	private SpringSwaggerConfig springSwaggerConfig;
	
	@Bean
	public SwaggerSpringMvcPlugin customImplementation(){
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
				.apiInfo(apiInfo())
				.includePatterns(".*?")
				.apiVersion("1.0.0")
				.swaggerGroup("user");
	}
	
	private ApiInfo apiInfo(){
		   ApiInfo apiInfo = new ApiInfo(  
		              "swagger-ceshi API",  
		              "CRUD 后台API文档",  
		              "<a href=http://127.0.0.1:8080/manager-web/dist" ,  
		              "zhuyanlong",  
		              "My License",  
		              "My Apps API License URL"  
		        );  
		      return apiInfo;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
}
