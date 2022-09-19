package com.harakte.searchblog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SearchBlogResDto {
    private Integer totalCount;
    private Integer pageableCount;
    private Boolean end;
    private List<BlogDto> blogs;
}
