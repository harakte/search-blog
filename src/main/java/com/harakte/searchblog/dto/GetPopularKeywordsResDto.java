package com.harakte.searchblog.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class GetPopularKeywordsResDto {
    private Integer count;
    private List<KeywordDto> keywords;

    public GetPopularKeywordsResDto(List<KeywordDto> keywords) {
        this.keywords = keywords;
        if(keywords != null){
            this.count = keywords.size();
        }
    }
}
