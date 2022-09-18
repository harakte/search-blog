package com.harakte.searchblog.engine.kakao.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harakte.searchblog.engine.kakao.dto.KakaoErrorResDto;
import com.harakte.searchblog.error.ApiException;
import com.harakte.searchblog.error.ErrorStatus;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;

public class KakaoErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        KakaoErrorResDto kakaoErrorResDto;
        try(InputStream bodyInputStream = response.body().asInputStream()){
            ObjectMapper objectMapper = new ObjectMapper();
            kakaoErrorResDto = objectMapper.readValue(bodyInputStream, KakaoErrorResDto.class);
        } catch (IOException ex) {
            throw new ApiException(ErrorStatus.KAKAO_SEARCH_BLOG_API_FAILED, ex);
        }
        return new ApiException(ErrorStatus.KAKAO_SEARCH_BLOG_API_FAILED, kakaoErrorResDto.toString());
    }
}
