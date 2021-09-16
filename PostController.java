package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "api/posts")
public class PostController {
    @Autowired
    private PostService service;
    @Autowired
    private CommentService commentService;

    @GetMapping
    public List <Post> getPosts(){
        return service.getPosts();
    }


    @PostMapping
    public Post createPost(@RequestBody() Post post){
        return service.createPost(post);
    }


    @PatchMapping
    public Post updatePost(@RequestBody Post post){
        return service.updatePost(post);
    }


    @DeleteMapping("/{id}")
    public boolean deletePost(@PathVariable(name = "id") Long id){
        return service.deletePost(id);
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @GetMapping("/{id}/comments")
    public List<Comment> getComments(@PathVariable("id") Long id){
        return service.getComments(id);
    }
    @PostMapping("/{id}/comments")
    public Post addComment(@PathVariable("id") Long id, @RequestBody() Comment comment){
        return service.addComment(id,comment);
    }

    @GetMapping("/search")
    public List<Post> search(@RequestParam("search") String search){
        return service.getPostsBySearchTerm(search);
    }

    @GetMapping("/comments")
    public Iterable <Comment> getComments(){
        return  commentService.getAll();
    }

}
