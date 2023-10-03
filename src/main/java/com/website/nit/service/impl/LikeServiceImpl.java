package com.website.nit.service.impl;

import com.website.nit.model.Likes;
import com.website.nit.repository.LikeRepository;
import com.website.nit.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeRepository likeRepository;

    @Override
    public Likes liked(Likes likes) {
        return likeRepository.save(likes);
    }

    @Override
    public ResponseEntity<Void> unliked(Likes likes) {
        likeRepository.delete(likes);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
