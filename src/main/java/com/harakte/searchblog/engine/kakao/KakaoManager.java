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

    public List<BlogDto> getBlogInfos(String keyword){
        int page = 1;
        List<BlogDto> blogInfos = new ArrayList<>();
        while (true){
            KakaoSearchBlogResDto resDto = kakaoClient.searchBlog(new KakaoSearchBlogReqDto(keyword, page,50));
            blogInfos.addAll(resDto.getDocuments().stream()
                    .map(BlogInfoMapper.INSTANCE::getBlogDto)
                    .collect(Collectors.toList()));
            if(Boolean.TRUE.equals(resDto.getMeta().getIsEnd())) {
                break;
            }
            page++;
        }
        return blogInfos;
    }
}
