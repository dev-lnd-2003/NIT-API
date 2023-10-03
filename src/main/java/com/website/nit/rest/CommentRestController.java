package com.website.nit.rest;

import com.website.nit.model.Comments;
import com.website.nit.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/comment")
public class CommentRestController {


    @Autowired
    CommentService commentService;

    @GetMapping("/list-comment")
    public List<Comments> listComment(){
        return commentService.findAllComment();
    }

    @PostMapping("/send-comment")
    public Comments sendComment(@RequestBody Comments comments){
        return commentService.sendComment(comments);
    }

    @DeleteMapping("/delete-comment/{id}")
    public void deleteComment(@RequestBody @PathVariable("id") Comments comments){
       commentService.deleteComment(comments);
    }

    @PutMapping("/edit-comment/{id}")
    public Comments editComment(@RequestBody @PathVariable("id") Comments comments){
        return commentService.editComment(comments);
    }
}
