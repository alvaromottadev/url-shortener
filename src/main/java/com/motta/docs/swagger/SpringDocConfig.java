package com.motta.docs.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("URL Shortener")
                        .description("This project is a URL shortener")
                        .version("1.0")
                )
                .tags(
                        Arrays.asList(
                                new Tag().name("URL").description("This is a endpoints for URL shorten and get original url")
                        )
                );
    }

}
