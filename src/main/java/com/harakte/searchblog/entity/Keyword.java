package com.harakte.searchblog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_keyword")
public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String word;

    @Column(nullable = false)
    private Integer searchCount;

    @Column(name = "create_date_time", nullable = false)
    private OffsetDateTime createDateTime;

    @Column(name = "update_date_time")
    private OffsetDateTime updateDateTime;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "keyword")
    private List<Blog> blogs;
}
