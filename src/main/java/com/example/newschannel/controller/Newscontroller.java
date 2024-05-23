package com.example.newschannel.controller;

import com.example.newschannel.model.NewsArticle;
import com.example.newschannel.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/news")
public class Newscontroller {
    @Autowired
    private NewsService newsService;

    @GetMapping("/common-topics")
    public Map<String, Integer> getCommonTopics(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<NewsArticle> articles = newsService.fetchNewsArticlesForDay(startDate, endDate);
        return newsService.calculateCommonTopics(articles);
    }

    @GetMapping("/keyword-count")
    public long getKeywordCount(
            @RequestParam String keyword,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return newsService.countKeywordOccurrences(keyword, startDate, endDate);
    }

    @GetMapping("/common-keywords")
    public Map<String, Integer> getCommonKeywords(
            @RequestParam int threshold,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return newsService.getCommonKeywords(threshold, startDate, endDate);
    }

    @GetMapping("/uncommon-keywords")
    public Map<String, Integer> getUncommonKeywords(
            @RequestParam int threshold,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return newsService.getUncommonKeywords(threshold, startDate, endDate);
    }


}
