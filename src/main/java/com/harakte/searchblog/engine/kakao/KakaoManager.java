package com.harakte.searchblog.engine.kakao;

import com.harakte.searchblog.dto.BlogDto;
import com.harakte.searchblog.engine.kakao.client.KakaoClient;
import com.harakte.searchblog.engine.kakao.dto.KakaoSearchBlogReqDto;
import com.harakte.searchblog.engine.kakao.dto.KakaoSearchBlogResDto;
import com.harakte.searchblog.mapper.BlogInfoMapper;
import com.harakte.searchblog.util.TFIDFCalculator;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class KakaoManager {

    private static final String REGEX = "[\"'\\{\\}\\[\\]/?.,;:|\\)\\(*~`!^\\-_+<>@#%\\=]";

    private final KakaoClient kakaoClient;

    public List<BlogDto> getBlogs(String keyword){
        int page = 0;
        List<BlogDto> blogs = new ArrayList<>();
        boolean end;
        do{
            page++;
            KakaoSearchBlogResDto resDto = kakaoClient.searchBlog(new KakaoSearchBlogReqDto(keyword, page,50));
            blogs.addAll(resDto.getDocuments().stream()
                    .map(BlogInfoMapper.INSTANCE::getBlogDto)
                    .collect(Collectors.toList()));
            end = resDto.getMeta().getIsEnd();
        }while (!end);

        return blogs.stream()
                .sorted((t1, t2) -> compare(t1, t2, keyword))
                .collect(Collectors.toList());
    }

    private int compare(BlogDto t1, BlogDto t2, String keyword){
        double tfidf1 = getTF(t1, keyword);
        double tfidf2 = getTF(t2, keyword);
        return Double.compare(tfidf2, tfidf1);
    }

    private double getTF(BlogDto blog, String keyword){
        List<String> terms = splitTitleAndContents(blog.getTitle(), blog.getContents());
        return TFIDFCalculator.tf(terms, keyword);
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
        return Arrays.asList(replacedDoc.split("\\s+")).stream()
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toList());
    }
}
