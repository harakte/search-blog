package com.harakte.searchblog.engine.kakao.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class KakaoConfig {

    @Value("${kakao.api.key}")
    private String restApiKey;

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor requestInterceptor(){
        return requestTemplate
                -> requestTemplate.header("Authorization", "KakaoAK "+ restApiKey);
    }

    @Bean
    public ErrorDecoder errorDecoder(){
        return new KakaoErrorDecoder();
    }
}
