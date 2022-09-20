package com.harakte.searchblog.service;

import com.harakte.searchblog.dao.KeywordRepository;
import com.harakte.searchblog.dto.*;
import com.harakte.searchblog.engine.kakao.KakaoManager;
import com.harakte.searchblog.entity.Blog;
import com.harakte.searchblog.entity.Keyword;
import com.harakte.searchblog.error.ApiException;
import com.harakte.searchblog.error.ErrorStatus;
import com.harakte.searchblog.mapper.BlogInfoMapper;
import com.harakte.searchblog.mapper.KeywordMapper;
import com.harakte.searchblog.sorter.Sorter;
import com.harakte.searchblog.sorter.SorterFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchBlogService {

    private final KakaoManager kakaoManager;
    private final KeywordRepository keywordRepository;
    private final SorterFactory sorterFactory;

    public SearchBlogResDto searchBlog(SearchBlogReqDto reqDto){
        List<BlogDto> blogDtos = getBlogs(reqDto.getKeyword());

        int page = 1;
        if(reqDto.getPage() != null && reqDto.getPage() > 0){
            page = reqDto.getPage();
        }

        int size = 10;
        if(reqDto.getSize() != null && reqDto.getSize() > 0){
            size = reqDto.getSize();
        }

        int skipCount = (page - 1) * size;
        if(skipCount > blogDtos.size()){
            throw new ApiException(ErrorStatus.PAGE_EXCEED_MAXIMUM);
        }

        boolean end = false;
        if(blogDtos.size() <= skipCount + size){
            end = true;
        }

        Sorter sorter = sorterFactory.getSorter(reqDto.getSort());
        List<BlogDto> pagingBlogDtos = blogDtos.stream()
                .sorted(sorter)
                .skip(skipCount)
                .limit(size)
                .collect(Collectors.toList());

        SearchBlogResDto resDto = new SearchBlogResDto();
        resDto.setTotalCount(blogDtos.size());
        resDto.setPageableCount(pagingBlogDtos.size());
        resDto.setBlogs(pagingBlogDtos);
        resDto.setEnd(end);
        return resDto;
    }

    public GetPopularKeywordsResDto getPopularKeywords(GetPopularKeywordsReqDto reqDto){
        int size = 10;
        if(reqDto.getSize() == null){
            size = reqDto.getSize();
        }

        List<Keyword> keywords = keywordRepository.findAllByOrderBySearchCountDesc(PageRequest.of(0, size));
        List<KeywordDto> keywordDtos = keywords.stream()
                .map(KeywordMapper.INSTANCE::getKeywordDto)
                .collect(Collectors.toList());
        return new GetPopularKeywordsResDto(keywordDtos);
    }

    private List<BlogDto> getBlogs(String word){
        Keyword keyword = getKeyword(word);
        if(keyword.getBlogs() == null || keyword.getBlogs().isEmpty()){
            return new ArrayList<>();
        }

        return keyword.getBlogs().stream()
                .map(BlogInfoMapper.INSTANCE::getBlogDto)
                .collect(Collectors.toList());
    }

    private Keyword getKeyword(String word){
        Keyword keyword = keywordRepository.findFirstByWord(word);
        if(keyword != null){
            keyword.setSearchCount(keyword.getSearchCount() + 1);
            keyword.setUpdDateTime(OffsetDateTime.now(ZoneOffset.UTC));
            return keywordRepository.save(keyword);
        }

        return insertKeyword(word);
    }

    private Keyword insertKeyword(String word){
        Keyword keyword = new Keyword();
        keyword.setWord(word);
        keyword.setSearchCount(1);
        keyword.setCreateDate(OffsetDateTime.now(ZoneOffset.UTC));

        List<BlogDto> blogDtos = kakaoManager.getBlogs(word);
        List<Blog> blogs = blogDtos.stream()
                .map(blogInfoDto -> BlogInfoMapper.INSTANCE.getBlog(keyword, blogInfoDto))
                .collect(Collectors.toList());
        keyword.setBlogs(blogs);

        return keywordRepository.save(keyword);
    }
}
