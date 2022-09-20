package com.harakte.searchblog.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus {
    SUCCESS(HttpStatus.OK, 0, "Success")
    ,BAD_REQUEST(HttpStatus.BAD_REQUEST, 400, "Bad request")
    ,KAKAO_SEARCH_BLOG_API_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, 1000, "Kakao search blog API was failed.")
    ,PAGE_EXCEED_MAXIMUM(HttpStatus.BAD_REQUEST, 1001, "Page exceeds the maximum.")
    ,NOT_SUPPORTED_SORT(HttpStatus.INTERNAL_SERVER_ERROR, 1002, "This sort is not supported.")
    ,UNKNOWN(HttpStatus.INTERNAL_SERVER_ERROR, 9999, "Unknown")
    ;

    private final HttpStatus httpStatus;
    private final Integer errorCode;
    private final String errorMessage;
}
