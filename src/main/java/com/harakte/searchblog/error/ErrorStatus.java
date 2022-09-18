package com.harakte.searchblog.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus {
    SUCCESS(HttpStatus.OK, 0, "Success")
    ,KAKAO_SEARCH_BLOG_API_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, 1000, "Kakao search blog API was failed.")
    ,UNKNOWN(HttpStatus.INTERNAL_SERVER_ERROR, 9999, "Unknown")
    ;

    private HttpStatus httpStatus;
    private Integer errorCode;
    private String errorMessage;
}
