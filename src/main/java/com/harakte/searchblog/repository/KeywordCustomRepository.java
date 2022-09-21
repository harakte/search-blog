package com.harakte.searchblog.repository;

import com.harakte.searchblog.entity.Blog;
import com.harakte.searchblog.entity.Keyword;

import java.util.List;

public interface KeywordCustomRepository {
    Keyword insertKeyword(Keyword keyword, List<Blog> blogs);
}
