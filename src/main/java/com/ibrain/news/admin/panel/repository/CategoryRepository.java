package com.ibrain.news.admin.panel.repository;

import com.ibrain.news.admin.panel.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {}
