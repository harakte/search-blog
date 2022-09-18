package com.harakte.searchblog.engine.kakao.config;

import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;

public class KakaoErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        try(InputStream bodyInputStream = response.body().asInputStream()){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
