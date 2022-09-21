package com.harakte.searchblog.mapper;

import com.harakte.searchblog.dto.BlogDto;
import com.harakte.searchblog.engine.kakao.dto.KakaoDocumentDto;
import com.harakte.searchblog.entity.Blog;
import com.harakte.searchblog.entity.Keyword;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.Assert.assertEquals;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogInfoMapperTest {

    @Test
    public void getBlogInfoDto_kakao_test(){
        String keyword = "test";
        KakaoDocumentDto kakaoDocumentDto = new KakaoDocumentDto();
        kakaoDocumentDto.setTitle("test title");
        BlogDto blog = BlogInfoMapper.INSTANCE.getBlogDto(keyword, kakaoDocumentDto);
        log.info(blog.toString());
        assertEquals(kakaoDocumentDto.getTitle(), blog.getTitle());
    }

    @Test
    public void getBlog_test(){
        Keyword keyword = new Keyword();
        keyword.setWord("111");

        BlogDto blogDto = new BlogDto();
        blogDto.setBlogName("111");
        blogDto.setContents("dfsfdfssdfsdf");
        blogDto.setUrl("dfdfdf");
        blogDto.setTitle("dfsffs");
        blogDto.setPostDateTime(OffsetDateTime.now(ZoneOffset.UTC));
        Blog blog = BlogInfoMapper.INSTANCE.getBlog(keyword, blogDto);

        log.info(blog.toString());
    }
}
