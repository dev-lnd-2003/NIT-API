package com.website.nit.repository;

import com.website.nit.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface NewsRepository extends JpaRepository<News,Integer> {

    @Query("SELECT n FROM News n order by Size(n.like) DESC")
    List<News> findAllOrderByLikesDesc();


    @Query("SELECT COUNT(n) FROM News n WHERE n.publishDate > :date")
    int countNewNewsCountInMonth(@Param("date") Date date);

}
