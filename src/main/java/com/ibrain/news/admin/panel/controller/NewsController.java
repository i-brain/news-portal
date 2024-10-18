package com.ibrain.news.admin.panel.controller;

import com.ibrain.news.admin.panel.entity.News;
import com.ibrain.news.admin.panel.response.ResponseWrapper;
import com.ibrain.news.admin.panel.service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<News> getNews() {
        return newsService.getNews();
    }
    @GetMapping("/category/{categoryId}")
    public List<News> getNewsByCategory(@PathVariable Long categoryId) {
        return newsService.getNewsByCategory(categoryId);
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper<Void>> addNews(@RequestBody News news) {
        News createdNews = newsService.addNews(news);
        return ResponseEntity.ok(new ResponseWrapper<>(true, "News added successfully", null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Long id, @RequestBody News news) {
        News updatedNews = newsService.updateNews(id, news);
        return ResponseEntity.ok(updatedNews);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseWrapper<Void>>  deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
        return ResponseEntity.ok(new ResponseWrapper<>(true, "News with id-" + id + " deleted", null));
    }
}