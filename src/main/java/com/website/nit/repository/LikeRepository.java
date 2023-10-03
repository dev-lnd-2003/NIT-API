package com.website.nit.repository;

import com.website.nit.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Likes,Integer> {


}
