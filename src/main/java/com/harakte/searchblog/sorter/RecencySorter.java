package com.harakte.searchblog.sorter;

import com.harakte.searchblog.constant.Sort;
import com.harakte.searchblog.dto.BlogDto;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class RecencySorter implements Sorter{
    @Override
    public Sort getSort() {
        return Sort.RECENCY;
    }

    @Override
    public int compare(BlogDto t1, BlogDto t2){
        OffsetDateTime offsetDateTime1 = t1.getPostDateTime();
        OffsetDateTime offsetDateTime2 = t2.getPostDateTime();
        return offsetDateTime2.compareTo(offsetDateTime1);
    }
}
