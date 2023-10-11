package com.website.nit.service.impl;

import com.website.nit.model.Comments;
import com.website.nit.model.Likes;
import com.website.nit.repository.CommentsRepository;
import com.website.nit.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentsRepository commentsRepository;

    @Override
    public Comments sendComment(Comments comments) {
        return commentsRepository.save(comments);
    }

    @Override
    public List<Comments> findAllComment() {
        return commentsRepository.findAll();
    }

    @Override
    public void deleteComment(Comments comments) {
        commentsRepository.delete(comments);
    }

    @Override
    public Comments editComment(Integer id, Comments comments) {
        Comments entity = findCommentById(id);
        if (entity !=null){
            entity.setContent(comments.getContent());
            return commentsRepository.save(entity);
        }
        return null;
    }

    @Override
    public Comments findCommentById(Integer id) {
        return commentsRepository.findById(id).orElse(null);
    }


}
