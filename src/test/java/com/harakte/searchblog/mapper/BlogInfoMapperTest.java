package com.harakte.searchblog.mapper;

import com.harakte.searchblog.dto.BlogInfoDto;
import com.harakte.searchblog.engine.kakao.dto.KakaoDocumentDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogInfoMapperTest {

    @Test
    public void toDto(){
        KakaoDocumentDto kakaoDocumentDto = new KakaoDocumentDto();
        kakaoDocumentDto.setTitle("test title");
        BlogInfoDto blogInfoDto = BlogInfoMapper.INSTANCE.toDto(kakaoDocumentDto);
        log.info(blogInfoDto.toString());
        assertEquals(kakaoDocumentDto.getTitle(), blogInfoDto.getTitle());
    }
}
