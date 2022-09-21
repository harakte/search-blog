package com.harakte.searchblog.engine;

import com.harakte.searchblog.dto.BlogDto;

import java.util.Set;

public interface EngineManager {
    Set<BlogDto> getBlogs(String keyword);
}
