package com.harakte.searchblog.repository;

import com.harakte.searchblog.entity.Blog;
import com.harakte.searchblog.entity.Keyword;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class KeywordCustomRepositoryImpl implements KeywordCustomRepository{

    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private int batchSize;

    private final EntityManager entityManager;

    @Override
    public Keyword insertKeyword(Keyword keyword, List<Blog> blogs) {
        entityManager.persist(keyword);
        for(int i = 0; i < blogs.size(); i++){
            if(i > 0 && i % batchSize == 0){
                entityManager.flush();
                entityManager.clear();
            }
            entityManager.persist(blogs.get(i));
        }
        keyword.setBlogs(blogs);
        return keyword;
    }
}
