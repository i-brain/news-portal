package com.ibrain.news.admin.panel.service;

import com.ibrain.news.admin.panel.entity.Category;
import com.ibrain.news.admin.panel.entity.News;
import com.ibrain.news.admin.panel.exception.ResourceNotFoundException;
import com.ibrain.news.admin.panel.repository.CategoryRepository;
import com.ibrain.news.admin.panel.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class NewsService {

    private final NewsRepository newsRepository;
    private final CategoryRepository categoryRepository;

    public NewsService(NewsRepository newsRepository, CategoryRepository categoryRepository) {
        this.newsRepository = newsRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<News> getNews() {
        return newsRepository.findAll();
    }

    public List<News> getNewsByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        return newsRepository.findByCategory(category);
    }

    public News addNews(News news) {
        return newsRepository.save(news);
    }

    // Update an existing news item
    public News updateNews(Long id, News updatedNews) {
        News existingNews = newsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("News not found"));
        existingNews.setTitle(updatedNews.getTitle());
        existingNews.setImageUrl(updatedNews.getImageUrl());
        existingNews.setDetails(updatedNews.getDetails());
        existingNews.setCategory(updatedNews.getCategory());
        return newsRepository.save(existingNews);
    }

    // Delete a news item
    public void deleteNews(Long id) {
        News news = newsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("News not found"));
        newsRepository.delete(news);
    }
}
