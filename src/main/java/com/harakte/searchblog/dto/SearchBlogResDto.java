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

    public SearchBlogResDto(Integer totalCount, Boolean end, List<BlogDto> blogs) {
        this.totalCount = totalCount;
        this.end = end;
        this.blogs = blogs;
        if(blogs != null && !blogs.isEmpty()){
            this.pageableCount = blogs.size();
        }
    }
}
