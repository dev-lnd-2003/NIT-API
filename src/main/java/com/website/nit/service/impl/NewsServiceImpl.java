package com.website.nit.service.impl;

import com.website.nit.model.News;
import com.website.nit.repository.NewsRepository;
import com.website.nit.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    @Override
    public News findById(Integer id) {
        Optional<News> optionalNews = newsRepository.findById(id);
        return optionalNews.orElse(null);
    }
}
