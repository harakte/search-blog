package com.harakte.searchblog.engine.kakao.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class KakaoSearchBlogResDto {
    private KakaoMetaDto meta;
    private List<KakaoDocumentDto> documents;
}
