package com.harakte.searchblog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GetPopularTermsResDto {
    private Integer count;
    private List<String> terms;
}
