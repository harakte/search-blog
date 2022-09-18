package com.harakte.searchblog.engine.kakao;

import com.harakte.searchblog.dto.BlogInfoDto;
import com.harakte.searchblog.mapper.BlogInfoMapper;
import com.harakte.searchblog.util.WithClasses;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
@WithClasses({
        BlogInfoMapper.class
})
public class KakaoManagerTest {

    @Autowired
    private KakaoManager kakaoManager;

    @Test
    public void getBlogInfos_test(){
        String keyword = "khafre";
        List<BlogInfoDto> blogInfos = kakaoManager.getBlogInfos(keyword);

        log.info(blogInfos.toString());
    }
}
