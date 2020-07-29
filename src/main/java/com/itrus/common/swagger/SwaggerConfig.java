package com.itrus.common.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>Title: SwaggerConfig.java</p>
 * <p>Description: swagger2 配置类</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: com.itrus</p>
 * @author wen_guoxing
 * @date 2019年8月9日
 * @version 1.0
 */

@SuppressWarnings("deprecation")
@Configuration

@EnableSwagger2 
public class SwaggerConfig extends WebMvcConfigurerAdapter {

	@Bean 
	public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(this.apiInfo()) .select() // 自行修改为自己的包路径
			.apis(RequestHandlerSelectors.basePackage("com.itrus.common.controller"))
			.paths(PathSelectors.any()) .build(); 
	}
	private ApiInfo apiInfo() { 
		return	new ApiInfoBuilder().title("api文档") 
				.description("restful 风格接口") //服务条款网址
				.termsOfServiceUrl("") 
				.version("2.2.0") 
				.contact(new Contact("hello","url", "email")) 
				.license("The Apache License")
                .licenseUrl("http://www.baidu.com")
				.build();
	}
	
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/");

	}
}

