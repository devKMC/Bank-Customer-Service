package com.devkmc.Bank_Customer_Service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // /api/** 경로로 오는 모든 요청에 대해 CORS 허용
            .allowedOrigins("http://localhost:5173") // 프론트엔드 URL
            .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메서드
            .allowedHeaders("*") // 모든 헤더를 허용
            .allowCredentials(true); // 쿠키나 인증 정보를 허용할지 여부
    }
}
