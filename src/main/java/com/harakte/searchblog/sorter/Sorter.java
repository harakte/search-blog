package com.harakte.searchblog.sorter;

import com.harakte.searchblog.constant.Sort;
import com.harakte.searchblog.dto.BlogDto;

import java.util.Comparator;

public interface Sorter extends Comparator<BlogDto> {
    Sort getSort();
}
