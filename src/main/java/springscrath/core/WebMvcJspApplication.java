/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springscrath.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 https://github.com/ghillert/spring-boot-jsp-demo
 * @author adiel
 */
@Configuration()
@SpringBootApplication
@ComponentScan("springscrath")
public class WebMvcJspApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebMvcJspApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebMvcJspApplication.class, args);

    }

}
