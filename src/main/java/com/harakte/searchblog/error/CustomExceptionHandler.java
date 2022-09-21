package com.harakte.searchblog.error;

import com.harakte.searchblog.error.dto.ErrorResDto;
import com.harakte.searchblog.error.mapper.ErrorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResDto> handleApiException(ApiException ex){
        ErrorStatus errorStatus = ex.getErrorStatus();
        return ResponseEntity.status(errorStatus.getHttpStatus())
                .body(ErrorMapper.INSTANCE.toErrorResDto(errorStatus));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResDto> handleRequestException(Exception ex){
        ErrorStatus errorStatus = ErrorStatus.METHOD_NOT_ALLOWED;
        return ResponseEntity.status(errorStatus.getHttpStatus())
                .body(ErrorMapper.INSTANCE.getErrorResDto(errorStatus, ex));
    }

    @ExceptionHandler({BindException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorResDto> handleBindException(Exception ex){
        ErrorStatus errorStatus = ErrorStatus.BAD_REQUEST;
        return ResponseEntity.status(errorStatus.getHttpStatus())
                .body(ErrorMapper.INSTANCE.getErrorResDto(errorStatus, ex));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResDto> handleException(Exception ex){
        ErrorStatus errorStatus = ErrorStatus.UNKNOWN;
        return ResponseEntity.status(errorStatus.getHttpStatus())
                .body(ErrorMapper.INSTANCE.getErrorResDto(errorStatus, ex));
    }
}
