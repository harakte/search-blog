package com.harakte.searchblog.mapper;

import com.harakte.searchblog.dto.BlogDto;
import com.harakte.searchblog.engine.kakao.dto.KakaoDocumentDto;
import com.harakte.searchblog.entity.Blog;
import com.harakte.searchblog.entity.Keyword;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BlogInfoMapper {

    BlogInfoMapper INSTANCE = Mappers.getMapper(BlogInfoMapper.class);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "contents", target = "contents")
    @Mapping(source = "url", target = "url")
    @Mapping(source = "blogname", target = "blogName")
    @Mapping(source = "datetime", target = "postDateTime")
    BlogDto getBlogDto(KakaoDocumentDto kakaoDocumentDto);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "contents", target = "contents")
    @Mapping(source = "url", target = "url")
    @Mapping(source = "blogName", target = "blogName")
    @Mapping(source = "postDateTime", target = "postDateTime")
    BlogDto getBlogDto(Blog blog);

    Blog getBlog(Keyword keyword, BlogDto blogDto);

    @AfterMapping
    default void setBlog(@MappingTarget Blog blog, Keyword keyword){
        blog.setKeyword(keyword);
    }
}
