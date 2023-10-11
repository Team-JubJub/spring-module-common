package com.zupzup.untact.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**") // CORS를 적용할 URL패턴 정의
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("*") // 허용할 HTTP method 지정
                .maxAge(3000); // 설정 시간만큼 pre-flight 리퀘스트 캐싱
    }
}
