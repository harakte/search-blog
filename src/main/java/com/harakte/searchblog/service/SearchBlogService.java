package com.harakte.searchblog.service;

import com.harakte.searchblog.dto.GetPopularTermsReqDto;
import com.harakte.searchblog.dto.GetPopularTermsResDto;
import com.harakte.searchblog.dto.SearchBlogReqDto;
import com.harakte.searchblog.dto.SearchBlogResDto;
import org.springframework.stereotype.Service;

@Service
public class SearchBlogService {

    public SearchBlogResDto searchBlog(SearchBlogReqDto reqDto){
        return new SearchBlogResDto();
    }

    public GetPopularTermsResDto getPopularTerms(GetPopularTermsReqDto reqDto){
        return new GetPopularTermsResDto();
    }
}
