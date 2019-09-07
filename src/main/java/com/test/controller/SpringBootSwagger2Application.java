package com.test.controller;

import com.sun.deploy.ui.AppInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SpringBootSwagger2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSwagger2Application.class,args);
    }

    @Bean
    public Docket swaggerConfiguration(){

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/*"))
                .apis(RequestHandlerSelectors.basePackage("com.test"))
                .build()
                .apiInfo(getApIInfo());
    }

    private ApiInfo getApIInfo(){

        return new ApiInfo(
                "Address Book API",
                "Sample API for swagger tutorial",
                "1.0",
                "Free to use",
                new Contact("Harinatha","","harinatha.k@gmail.com"),
                "API Licence",
                "",
                Collections.emptyList());
    }
}
