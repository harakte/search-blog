package com.harakte.searchblog.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BlogInfoDto {
    private String title;
    private String contents;
    private String url;
    private String bloggerName;
    private LocalDateTime postDateTime;
}
