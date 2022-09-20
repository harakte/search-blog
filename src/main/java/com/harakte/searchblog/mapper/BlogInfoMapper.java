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

    @Mapping(source = "document.title", target = "title")
    @Mapping(source = "document.contents", target = "contents")
    @Mapping(source = "document.url", target = "url")
    @Mapping(source = "document.blogname", target = "blogName")
    @Mapping(source = "document.datetime", target = "postDateTime")
    @Mapping(source = "word", target = "word")
    BlogDto getBlogDto(String word, KakaoDocumentDto document);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "contents", target = "contents")
    @Mapping(source = "url", target = "url")
    @Mapping(source = "blogName", target = "blogName")
    @Mapping(source = "postDateTime", target = "postDateTime")
    @Mapping(source = "keyword.word", target = "word")
    BlogDto getBlogDto(Blog blog);

    @Mapping(source = "keyword", target = "keyword")
    Blog getBlog(Keyword keyword, BlogDto blogDto);
}
