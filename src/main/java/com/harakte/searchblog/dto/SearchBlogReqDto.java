package com.harakte.searchblog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class SearchBlogReqDto {

    @NotBlank
    private String keyword;

    private String sort;

    @Min(1)
    private Integer page;

    @Min(1)
    @Max(50)
    private Integer size;
}
