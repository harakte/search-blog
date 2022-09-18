package com.harakte.searchblog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetPopularTermsReqDto {
    private Integer size;
}
