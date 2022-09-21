package com.harakte.searchblog.dto;

import com.harakte.searchblog.constant.Sort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class SearchBlogReqDto {

    @NotBlank
    private String keyword;

    private Sort sort;

    @Min(1)
    private Integer page;

    @Min(1)
    @Max(50)
    private Integer size;
}
