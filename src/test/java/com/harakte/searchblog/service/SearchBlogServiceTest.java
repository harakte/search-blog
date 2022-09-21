package com.harakte.searchblog.service;

import com.harakte.searchblog.dto.SearchBlogReqDto;
import com.harakte.searchblog.dto.SearchBlogResDto;
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
public class SearchBlogServiceTest {

    @Autowired
    private SearchBlogService searchBlogService;

    @Test
    public void searchBlog_test(){
        SearchBlogReqDto reqDto = new SearchBlogReqDto();
        reqDto.setKeyword("khafre");
        reqDto.setPage(1);
        reqDto.setSize(10);

        SearchBlogResDto resDto = searchBlogService.searchBlog(reqDto);
        log.info(resDto.toString());
    }
}
