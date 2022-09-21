package com.harakte.searchblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@Table(name = "tb_blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "keyword_id", nullable = false)
    @JsonIgnore
    private Keyword keyword;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String contents;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String blogName;

    @Column(nullable = false)
    private OffsetDateTime postDateTime;
}
