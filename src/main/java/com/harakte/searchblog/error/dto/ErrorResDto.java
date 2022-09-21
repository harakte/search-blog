package com.harakte.searchblog.error.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResDto {
    private Integer errorCode;
    private String errorMessage;
}
