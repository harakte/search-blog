package com.harakte.searchblog.error;

import com.harakte.searchblog.error.dto.ErrorResDto;
import com.harakte.searchblog.error.mapper.ErrorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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

//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<ErrorResDto> handleException(Exception ex){
//        ErrorResDto resDto = new ErrorResDto();
//        resDto.setErrorCode();
//        resDto.setErrorMessage(ex.getMessage());
//        return ResponseEntity.status(httpStatus)
//                .body(resDto);
//    }
}
