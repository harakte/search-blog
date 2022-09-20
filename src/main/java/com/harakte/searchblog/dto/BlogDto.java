package com.harakte.searchblog.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
public class BlogDto {
    @JsonIgnore
    private String word;

    private String title;
    private String contents;
    private String url;
    private String blogName;
    private OffsetDateTime postDateTime;
}
