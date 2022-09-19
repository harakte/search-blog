package com.harakte.searchblog.config.converter;

import com.harakte.searchblog.constant.Sort;
import com.harakte.searchblog.error.ApiException;
import com.harakte.searchblog.error.ErrorStatus;
import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;

public class SortConverter implements Converter<String, Sort> {

    @Override
    public Sort convert(String source) {
        return Arrays.stream(Sort.values())
                .filter(sort -> sort.name().equals(source.toUpperCase()))
                .findAny()
                .orElseThrow(() -> new ApiException(ErrorStatus.BAD_REQUEST));
    }
}
