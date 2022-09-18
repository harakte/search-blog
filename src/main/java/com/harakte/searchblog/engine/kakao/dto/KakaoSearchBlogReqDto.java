package com.harakte.searchblog.engine.kakao.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KakaoSearchBlogReqDto {
    private String query;
    private String sort;
    private Integer page;
    private Integer size;

    public KakaoSearchBlogReqDto(String query, Integer page, Integer size) {
        this.query = query;
        this.page = page;
        this.size = size;
    }
}
