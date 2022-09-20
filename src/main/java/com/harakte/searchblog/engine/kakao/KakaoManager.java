package com.harakte.searchblog.engine.kakao;

import com.harakte.searchblog.dto.BlogDto;
import com.harakte.searchblog.engine.kakao.client.KakaoClient;
import com.harakte.searchblog.engine.kakao.dto.KakaoSearchBlogReqDto;
import com.harakte.searchblog.engine.kakao.dto.KakaoSearchBlogResDto;
import com.harakte.searchblog.mapper.BlogInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class KakaoManager {
    private final KakaoClient kakaoClient;

    public List<BlogDto> getBlogs(String keyword){
        int page = 0;
        List<BlogDto> blogs = new ArrayList<>();
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
