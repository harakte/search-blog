package com.harakte.searchblog.error.mapper;

import com.harakte.searchblog.error.ErrorStatus;
import com.harakte.searchblog.error.dto.ErrorResDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ErrorMapper {

    ErrorMapper INSTANCE = Mappers.getMapper(ErrorMapper.class);

    ErrorResDto toErrorResDto(ErrorStatus errorStatus);

    @Mapping(source = "errorStatus.errorCode", target = "errorCode")
    @Mapping(source = "exception.message", target = "errorMessage")
    ErrorResDto getErrorResDto(ErrorStatus errorStatus, Exception exception);
}
