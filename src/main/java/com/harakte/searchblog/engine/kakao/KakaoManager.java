package com.harakte.searchblog.engine.kakao;

import com.harakte.searchblog.dto.BlogDto;
import com.harakte.searchblog.engine.kakao.client.KakaoClient;
import com.harakte.searchblog.engine.kakao.dto.KakaoSearchBlogReqDto;
import com.harakte.searchblog.engine.kakao.dto.KakaoSearchBlogResDto;
import com.harakte.searchblog.mapper.BlogInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class KakaoManager {
    private final KakaoClient kakaoClient;

    public Set<BlogDto> getBlogs(String keyword){
        int page = 0;
        Set<BlogDto> blogs = new HashSet<>();
        boolean end;
        do{
            page++;
            KakaoSearchBlogResDto resDto = kakaoClient.searchBlog(new KakaoSearchBlogReqDto(keyword, page,50));
            blogs.addAll(resDto.getDocuments().stream()
                    .map(documentDto -> BlogInfoMapper.INSTANCE.getBlogDto(keyword, documentDto))
                    .collect(Collectors.toList()));
            end = resDto.getMeta().getIsEnd();
        }while (!end);

        return blogs;
    }
}
