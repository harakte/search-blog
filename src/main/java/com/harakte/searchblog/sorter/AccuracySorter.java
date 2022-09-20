package com.harakte.searchblog.sorter;

import com.harakte.searchblog.constant.Sort;
import com.harakte.searchblog.dto.BlogDto;
import com.harakte.searchblog.util.TFIDFCalculator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccuracySorter implements Sorter{

    private static final String REGEX = "[\"'\\{\\}\\[\\]/?.,;:|\\)\\(*~`!^\\-_+<>@#%\\=]";
    @Override
    public Sort getSort() {
        return Sort.ACCURACY;
    }

    @Override
    public int compare(BlogDto t1, BlogDto t2) {
        double tfidf1 = getTF(t1, t1.getWord());
        double tfidf2 = getTF(t2, t2.getWord());
        return Double.compare(tfidf2, tfidf1);
    }

    private double getTF(BlogDto blog, String word){
        List<String> doc = splitTitleAndContents(blog.getTitle(), blog.getContents());
        return TFIDFCalculator.tf(doc, word);
    }

    private List<String> splitTitleAndContents(String title, String contents){
        List<String> terms = new ArrayList<>();
        terms.addAll(split(title));
        terms.addAll(split(contents));
        return terms;
    }

    private List<String> split(String doc){
        if(StringUtils.isBlank(doc)){
            return new ArrayList<>();
        }
        String replacedDoc = doc.replaceAll(REGEX, " ");
        if(StringUtils.isBlank(replacedDoc)){
            return new ArrayList<>();
        }
        return Arrays.stream(replacedDoc.split("\\s+"))
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toList());
    }
}
