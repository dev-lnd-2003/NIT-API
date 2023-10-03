package com.website.nit.rest;

import com.website.nit.model.Likes;
import com.website.nit.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/like")
@CrossOrigin("*")
public class LikeRestController {

    @Autowired
    LikeService likeService;

    @PostMapping("/send-like")
    public Likes sendLike(@RequestBody Likes likes){
        return likeService.liked(likes);
    }

    @DeleteMapping("/un-liked/{id}")
    public void unLike(@RequestBody @PathVariable("id") Likes likes){
        likeService.unliked(likes);
    }
}
