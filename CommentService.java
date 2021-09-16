package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    public Comment createComment(@RequestParam(name = "post_id") Long id, @RequestParam(name = "content") String content){
        Comment comment = new Comment(content);
        comment.setPost(postRepository.findById(id).get());
        return commentRepository.save(comment);
    }

    public Iterable<Comment> getAll(){
        return commentRepository.findAll();
    }
}
