package com.harakte.searchblog.mapper;

import com.harakte.searchblog.dto.KeywordDto;
import com.harakte.searchblog.entity.Keyword;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KeywordMapper {
    KeywordMapper INSTANCE = Mappers.getMapper(KeywordMapper.class);

    @Mapping(source = "word", target = "word")
    @Mapping(source = "searchCount", target = "count")
    KeywordDto getKeywordDto(Keyword keyword);
}
