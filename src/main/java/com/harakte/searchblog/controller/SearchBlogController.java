package com.harakte.searchblog.controller;

import com.harakte.searchblog.dto.GetPopularKeywordsReqDto;
import com.harakte.searchblog.dto.GetPopularKeywordsResDto;
import com.harakte.searchblog.dto.SearchBlogReqDto;
import com.harakte.searchblog.dto.SearchBlogResDto;
import com.harakte.searchblog.service.SearchBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SearchBlogController {

    private final SearchBlogService searchBlogService;

    @GetMapping("/search/blog")
    public SearchBlogResDto searchBlog(@Valid final SearchBlogReqDto reqDto){
        return searchBlogService.searchBlog(reqDto);
    }

    @GetMapping("/popular/keywords")
    public GetPopularKeywordsResDto getPopularKeywords(@Valid final GetPopularKeywordsReqDto reqDto){
        return searchBlogService.getPopularKeywords(reqDto);
    }
}
