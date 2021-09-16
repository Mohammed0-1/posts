package com.example.demo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Comment {
    private @Id @GeneratedValue Long id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "PK_ID")
    private Post post;

    public Comment(){}
    public Comment(String content){
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) &&
                Objects.equals(content, comment.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id,content);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", post=" + post.toString() +
                '}';
    }
}
