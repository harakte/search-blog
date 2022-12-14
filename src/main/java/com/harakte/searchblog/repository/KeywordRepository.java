package com.harakte.searchblog.repository;

import com.harakte.searchblog.entity.Keyword;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long>, KeywordCustomRepository {
    Keyword findFirstByWord(String word);

    List<Keyword> findAllByOrderBySearchCountDesc(PageRequest pageRequest);
}
