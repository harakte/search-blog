package com.harakte.searchblog.engine.kakao.client;

import com.harakte.searchblog.engine.kakao.config.KakaoConfig;
import com.harakte.searchblog.engine.kakao.dto.KakaoSearchBlogReqDto;
import com.harakte.searchblog.engine.kakao.dto.KakaoSearchBlogResDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "kakao-client", url = "${kakao.api.url}", configuration = KakaoConfig.class)
public interface KakaoClient {

    @GetMapping(value = "/v2/search/blog", consumes = MediaType.APPLICATION_JSON_VALUE)
    KakaoSearchBlogResDto searchBlog(@RequestParam @SpringQueryMap KakaoSearchBlogReqDto reqDto);
}
