package com.wework.platformservice.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .build();
        docket.apiInfo(apiInfo());
        return docket;
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("LanJe API Doc")
                .description("This is a restful api document of LanJe.")
                .version("1.0")
                .build();
    }

}