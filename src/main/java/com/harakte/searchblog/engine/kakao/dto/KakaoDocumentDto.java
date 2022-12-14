package com.harakte.searchblog.engine.kakao.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
public class KakaoDocumentDto {
    private String title;
    private String contents;
    private String url;
    private String blogname;
    private String thumbnail;
    private OffsetDateTime datetime;
}
