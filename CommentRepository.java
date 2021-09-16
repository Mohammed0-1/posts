package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment,Long> {
    public List<Comment> getCommentsByPostId(Long Id);
}
