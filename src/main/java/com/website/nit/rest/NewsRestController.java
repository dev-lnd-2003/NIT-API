package com.website.nit.rest;

import com.website.nit.model.News;
import com.website.nit.repository.NewsRepository;
import com.website.nit.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@CrossOrigin("*")
public class NewsRestController {

    @Autowired
    NewsService newsService;
    @GetMapping("/list-news")
    public List<News> listNews(){
        return newsService.findAll();
    }
}
