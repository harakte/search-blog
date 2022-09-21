package com.harakte.searchblog.engine.kakao.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class KakaoErrorResDto {
    private String errorType;
    private String message;
}
