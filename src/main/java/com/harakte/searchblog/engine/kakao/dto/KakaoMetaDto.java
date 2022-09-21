package com.harakte.searchblog.engine.kakao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class KakaoMetaDto {
    @JsonProperty("total_count")
    private Integer totalCount;
    @JsonProperty("pageable_count")
    private Integer pageableCount;
    @JsonProperty("is_end")
    private Boolean isEnd;
}
