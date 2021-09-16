package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,Long>{

    public List <Post> findByTitle(String title);

    @Query("SELECT p FROM Post p WHERE p.title LIKE %:st% OR p.content LIKE %:st%")
    public List <Post> findByTitleOrContent(String st);
}
