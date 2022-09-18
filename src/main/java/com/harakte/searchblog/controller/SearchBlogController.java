package com.harakte.searchblog.controller;

import com.harakte.searchblog.dto.GetPopularTermsReqDto;
import com.harakte.searchblog.dto.GetPopularTermsResDto;
import com.harakte.searchblog.dto.SearchBlogReqDto;
import com.harakte.searchblog.dto.SearchBlogResDto;
import com.harakte.searchblog.service.SearchBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SearchBlogController {

    private final SearchBlogService searchBlogService;

    @GetMapping("/test")
    public String test(@RequestParam String keyword){
        return keyword;
    }

    @GetMapping("/search/blog")
    public SearchBlogResDto searchBlog(@Valid final SearchBlogReqDto reqDto){
        return searchBlogService.searchBlog(reqDto);
    }

    @GetMapping("/popular/terms")
    public GetPopularTermsResDto getPopularTerms(@Valid final GetPopularTermsReqDto reqDto){
        return searchBlogService.getPopularTerms(reqDto);
    }
}
