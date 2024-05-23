package com.example.newschannel.service;

import com.example.newschannel.model.NewsApiResponse;
import com.example.newschannel.model.NewsArticle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ExternalNewsService {
    @Value("${news.api.url}")
    private String apiUrl;

    @Value("${news.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<NewsArticle> fetchExternalNewsForDay(Date startDate, Date endDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String url = String.format("%s?q=Apple&from=%s&to=%s&sortBy=popularity&apiKey=%s",
                apiUrl, dateFormat.format(startDate), dateFormat.format(endDate), apiKey);

        // Make an HTTP GET request to the API
        NewsApiResponse response = restTemplate.getForObject(url, NewsApiResponse.class);

        if (response != null) {
            return response.getArticles();
        } else {
            return Arrays.asList();
        }
    }

}
