package com.harakte.searchblog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class SearchBlogReqDto {

    @NotBlank
    private String keyword;

    private String sort;

    private Integer page;

    private Integer size;
}
