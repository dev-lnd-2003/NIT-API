package com.website.nit.repository;

import com.website.nit.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface CommentsRepository extends JpaRepository<Comments,Integer> {

    @Query("SELECT COUNT(c) FROM Comments c WHERE c.createDate > :date")
    int countNewCommentCountInMonth(@Param("date") Date date);
}
