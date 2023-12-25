package com.example.kuaforrandevu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
public void addCorsMappings(CorsRegistry registry){
    registry.addMapping("/api/**")
            .allowedOrigins("http://127.0.0.1:5501/")
            .allowedMethods("GET","POST","PUT","DELETE");
}
}