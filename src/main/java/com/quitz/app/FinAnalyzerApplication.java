package com.quitz.app;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

@SpringBootApplication
@ComponentScan({"com.quitz"})
@EnableJpaRepositories("com.quitz.repository")
@EntityScan("com.quitz.model")
public class FinAnalyzerApplication {
	
	public static void main(String[] args) {
		// Fix timezone issue which is one day off from database after serialization
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(FinAnalyzerApplication.class, args);
	}
	
	/*
    @Controller
    @ApiIgnore
    static class SwaggerWelcome {
            @GetMapping({"/doc", "/api"})
            public String redirectToUi() {
                    return "redirect:/swagger-ui.html";
            }
    }*/
}
