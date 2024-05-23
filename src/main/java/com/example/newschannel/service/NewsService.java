package com.example.newschannel.service;

import com.example.newschannel.model.NewsArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NewsService {
    @Autowired
    private ExternalNewsService externalNewsService;

    public List<NewsArticle> fetchNewsArticlesForDay(Date startDate, Date endDate) {
        return externalNewsService.fetchExternalNewsForDay(startDate, endDate);
    }

    public Map<String, Integer> calculateCommonTopics(List<NewsArticle> articles) {
        Map<String, Integer> topicFrequency = new HashMap<>();

        for (NewsArticle article : articles) {
            String[] tokens = article.getContent().split("\\s+");
            for (String token : tokens) {
                topicFrequency.put(token, topicFrequency.getOrDefault(token, 0) + 1);
            }
        }

        return topicFrequency;
    }

    public long countKeywordOccurrences(String keyword, Date startDate, Date endDate) {
        List<NewsArticle> articles = fetchNewsArticlesForDay(startDate,endDate);
        return articles.stream()
                .filter(article -> article.getContent().contains(keyword))
                .count();
    }

    public Map<String, Integer> getCommonKeywords(int threshold, Date startDate, Date endDate) {
        List<NewsArticle> articles = fetchNewsArticlesForDay(startDate,endDate);
        Map<String, Integer> topicFrequency = calculateCommonTopics(articles);
        return topicFrequency.entrySet().stream()
                .filter(entry -> entry.getValue() >= threshold)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<String, Integer> getUncommonKeywords(int threshold,Date startDate, Date endDate) {
        List<NewsArticle> articles = fetchNewsArticlesForDay(startDate,endDate);
        Map<String, Integer> topicFrequency = calculateCommonTopics(articles);
        return topicFrequency.entrySet().stream()
                .filter(entry -> entry.getValue() < threshold)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
