package com.harakte.searchblog.sorter;

import com.harakte.searchblog.constant.Sort;
import com.harakte.searchblog.error.ApiException;
import com.harakte.searchblog.error.ErrorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SorterFactory {

    private final List<Sorter> sorters;

    private final AccuracySorter accuracySorter;

    public Sorter getSorter(Sort sort){
        if(sort == null){
            return accuracySorter;
        }

        return sorters.stream()
                .filter(sorter -> sort.equals(sorter.getSort()))
                .findAny()
                .orElseThrow(()->new ApiException(ErrorStatus.NOT_SUPPORTED_SORT));
    }

}
