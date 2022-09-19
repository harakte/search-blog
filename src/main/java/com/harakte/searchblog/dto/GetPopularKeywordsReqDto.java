package com.harakte.searchblog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
public class GetPopularKeywordsReqDto {

    @Max(10)
    @Min(1)
    private Integer size;
}
