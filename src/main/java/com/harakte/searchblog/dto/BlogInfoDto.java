package com.harakte.searchblog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
public class BlogInfoDto {
    private String title;
    private String contents;
    private String url;
    private String blogName;
    private OffsetDateTime postDateTime;
}
