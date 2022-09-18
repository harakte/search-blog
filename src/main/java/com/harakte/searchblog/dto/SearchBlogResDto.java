package com.harakte.searchblog.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchBlogResDto {
    private Integer totalCount;
    private Integer pageableCount;
    private Boolean isEnd;
    private List<BlogInfoDto> blogs;
}
