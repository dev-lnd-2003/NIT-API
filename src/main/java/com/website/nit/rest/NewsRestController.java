package com.website.nit.rest;

import com.website.nit.model.News;
import com.website.nit.repository.NewsRepository;
import com.website.nit.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{newsId}/comment-count")
    public int getCommentCount(@PathVariable Integer newsId){
        News news = newsService.findById(newsId);
        if (news !=null && news.getComment() != null){
            return (int) news.getComment().size();
        }
        return 0;
    }

    @GetMapping("/{likeId}/like-count")
    public int getLikeCount(@PathVariable Integer likeId){
        News news = newsService.findById(likeId);
        if (news != null && news.getLike() !=null){
            return (int) news.getLike().size();
        }
        return 0;
    }
}
