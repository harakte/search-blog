package com.harakte.searchblog.engine.kakao.client;

import com.harakte.searchblog.engine.kakao.dto.KakaoSearchBlogReqDto;
import com.harakte.searchblog.engine.kakao.dto.KakaoSearchBlogResDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@Slf4j
@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class KakaoClientTest {

    @Autowired
    private KakaoClient kakaoClient;

    @Test
    public void searchBlog_test(){
        KakaoSearchBlogReqDto reqDto = new KakaoSearchBlogReqDto("kakao");
        KakaoSearchBlogResDto resDto = kakaoClient.searchBlog(reqDto);

        log.info(resDto.toString());
    }
}
