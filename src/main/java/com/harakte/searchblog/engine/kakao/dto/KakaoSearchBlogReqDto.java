package com.harakte.searchblog.engine.kakao.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoSearchBlogReqDto {
    private String query;
    private String sort;
    private Integer page;
    private Integer size;
}
