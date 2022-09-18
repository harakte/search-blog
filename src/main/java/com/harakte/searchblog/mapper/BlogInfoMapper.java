package com.harakte.searchblog.mapper;

import com.harakte.searchblog.dto.BlogInfoDto;
import com.harakte.searchblog.engine.kakao.dto.KakaoDocumentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BlogInfoMapper {

    BlogInfoMapper INSTANCE = Mappers.getMapper(BlogInfoMapper.class);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "contents", target = "contents")
    @Mapping(source = "url", target = "url")
    @Mapping(source = "blogname", target = "blogName")
    @Mapping(source = "datetime", target = "postDateTime")
    BlogInfoDto toDto(KakaoDocumentDto kakaoDocumentDto);

}
