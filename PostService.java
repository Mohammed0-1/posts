package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository ;
    @Autowired
    private CommentRepository commentRepository;

    public List<Post> getPosts(){
        Iterator<Post> iter = repository.findAll().iterator();
        List<Post> posts = new LinkedList<>();
        while(iter.hasNext()){
            posts.add(iter.next());
        }
        return posts;
    }

    public Post createPost(Post post){
        return repository.save(post);
    }

    public Post getById(Long id){
        return repository.findById(id).get();
    }

    public Post updatePost(Post updatedpost){
        Post post = repository.findById(updatedpost.getId()).get();
        post.setTitle(updatedpost.getTitle());
        post.setContent(updatedpost.getContent());
        return repository.save(post);
    }

    public Boolean deletePost(Long id){
        Post post = repository.findById(id).get();

        repository.delete(post);

        return true;
    }

    public List<Post> getPostsBySearchTerm(String search){
        return repository.findByTitleOrContent(search);
    }

    public List<Comment> getComments(Long id) {;
        return  commentRepository.getCommentsByPostId(id);
    }

    public Post addComment(Long id, Comment comment) {
        Post post = repository.findById(id).get();
        Comment repoComment = new Comment(comment.getContent());
        repoComment.setPost(post);
        Comment cmnt = commentRepository.save(repoComment);
        List<Comment> current = post.getComments();
        current.add(cmnt);
        post.setComments(current);
        return repository.save(post);
    }
}
