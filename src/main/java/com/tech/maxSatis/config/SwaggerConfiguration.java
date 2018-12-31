package com.tech.maxSatis.config;

import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * {@link Configuration} to {@link EnableSwagger2}.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().title("Techolution Maximum Satisfation").build())
                .enableUrlTemplating(true)
                .pathMapping("/")
                .select()
                .apis(withClassAnnotation(Api.class))
                .build();
    }
}
