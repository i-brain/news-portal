package com.ibrain.news.admin.panel.repository;

import com.ibrain.news.admin.panel.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {}
