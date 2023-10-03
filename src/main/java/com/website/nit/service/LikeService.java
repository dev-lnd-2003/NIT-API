package com.website.nit.service;

import com.website.nit.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface LikeService  {

    Likes liked(Likes likes);

    ResponseEntity<Void> unliked(Likes likes);
}
