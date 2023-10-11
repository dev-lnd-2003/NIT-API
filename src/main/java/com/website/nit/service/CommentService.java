package com.website.nit.service;


import com.website.nit.model.Comments;

import java.util.List;

public interface CommentService {

    Comments sendComment(Comments comments);

    List<Comments> findAllComment();

    void deleteComment(Comments comments);

    Comments editComment(Integer id, Comments comments);

    Comments findCommentById(Integer id);

}
