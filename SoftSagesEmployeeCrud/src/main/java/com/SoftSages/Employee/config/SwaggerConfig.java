package com.SoftSages.Employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {
	 
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.SoftSages.Employee.Controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(metaData());
    }
      

	 private ApiInfo metaData() {
	        return new ApiInfoBuilder()
	                .title("SoftSages Employee CRUD Operation")
	                .description("\"SoftSages Crud application \"")
	                .contact(new Contact("Amit Singh Chauhan", "amitgwalior.vitm@gmail.com","7999517805"))
	                .build();
	    }
	}