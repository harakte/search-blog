package com.harakte.searchblog.error;

import com.harakte.searchblog.error.dto.ErrorResDto;
import com.harakte.searchblog.error.mapper.ErrorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ErrorResDto> handleApiException(ApiException ex){
        ErrorStatus errorStatus = ex.getErrorStatus();
        return ResponseEntity.status(errorStatus.getHttpStatus())
                .body(ErrorMapper.INSTANCE.toErrorResDto(errorStatus));
    }

    @ExceptionHandler(value = BindException.class)
    public ResponseEntity<ErrorResDto> handleBindException(BindException ex){
        ErrorStatus errorStatus = ErrorStatus.BAD_REQUEST;
        ErrorResDto resDto = new ErrorResDto();
        resDto.setErrorCode(errorStatus.getErrorCode());
        resDto.setErrorMessage(ex.getMessage());
        return ResponseEntity.status(errorStatus.getHttpStatus())
                .body(resDto);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResDto> handleException(Exception ex){
        ErrorStatus errorStatus = ErrorStatus.UNKNOWN;
        ErrorResDto resDto = new ErrorResDto();
        resDto.setErrorCode(errorStatus.getErrorCode());
        resDto.setErrorMessage(ex.getMessage());
        return ResponseEntity.status(errorStatus.getHttpStatus())
                .body(resDto);
    }
}
