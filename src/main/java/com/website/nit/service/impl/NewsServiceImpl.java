package com.website.nit.service.impl;

import com.website.nit.model.News;
import com.website.nit.repository.NewsRepository;
import com.website.nit.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }
}
